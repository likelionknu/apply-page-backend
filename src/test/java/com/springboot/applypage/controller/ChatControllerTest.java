package com.springboot.applypage.controller;

import com.google.gson.Gson;
import com.springboot.applypage.data.dto.ChatDto;
import com.springboot.applypage.service.impl.ChatServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChatController.class)
public class ChatControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatServiceImpl chatService;

    @Test
    @DisplayName("ChatController get chats method Test")
    void getChatsTest() throws Exception{
        List<ChatDto> chats = new LinkedList<>();
        ChatDto chat1 = new ChatDto("내 이름은");
        ChatDto chat2 = new ChatDto("성창규인데");
        ChatDto chat3 = new ChatDto("너는 대체 누구닝?");
        ChatDto chat4 = new ChatDto("살려줘 ㅠㅠ");

        chats.add(chat1);
        chats.add(chat2);
        chats.add(chat3);
        chats.add(chat4);

        given(chatService.getChat()).willReturn(chats);

        mockMvc.perform(
                        get("/chat"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].msg").exists())
                .andExpect(jsonPath("$[1].msg").exists())
                .andExpect(jsonPath("$[2].msg").exists())
                .andExpect(jsonPath("$[3].msg").exists())
                .andDo(print());

        verify(chatService).getChat();

    }

    @Test
    @DisplayName("ChatController insert chat method Test")
    void insertChatTest() throws Exception{
        given(chatService.saveChat(new ChatDto("라면이 먹고싶다잉")))
                .willReturn(new ChatDto("라면이 먹고싶다잉"));
        ChatDto chatDto = new ChatDto("라면이 먹고싶다잉");

        Gson gson = new Gson();
        String query = gson.toJson(chatDto);

        mockMvc.perform(
                        post("/chat")
                                .content(query)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg").exists())
                .andDo(print());

        verify(chatService).saveChat(new ChatDto("라면이 먹고싶다잉"));

    }
}
