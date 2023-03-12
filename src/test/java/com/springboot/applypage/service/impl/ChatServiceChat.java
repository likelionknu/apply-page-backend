package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.ChatDAO;
import com.springboot.applypage.data.dto.ChatDto;
import com.springboot.applypage.data.entity.Chat;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.data.enumdata.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

public class ChatServiceChat {

    private ChatDAO chatDAO = Mockito.mock(ChatDAO.class);
    private ChatServiceImpl chatService;

    @BeforeEach
    void setUpTest(){
        chatService = new ChatServiceImpl(chatDAO);
    }

    @Test
    void saveChatTest(){
        Mockito.when(chatDAO.insertChat(any(Chat.class)))
                .then(returnsFirstArg());

        ChatDto chatDto = chatService.saveChat(new ChatDto("라면먹고싶어요"));
        Assertions.assertEquals(chatDto.getMsg(), "라면먹고싶어요");
    }

    @Test
    void getChatTest(){
        List<Chat> chats = new LinkedList<>();
        Chat chat1 = new Chat(1L, "안녕하세요");
        Chat chat2 = new Chat(2L, "제 이름은");
        Chat chat3 = new Chat(3L, "성창규");
        Chat chat4 = new Chat(4L, "입니다.");

        chats.add(chat1);
        chats.add(chat2);
        chats.add(chat3);
        chats.add(chat4);

        Mockito.when(chatDAO.getChats()).thenReturn(chats);
        List<ChatDto> chatDtos = chatService.getChat();
        Assertions.assertEquals(chatDtos.get(0).getMsg(), "안녕하세요");
        Assertions.assertEquals(chatDtos.get(1).getMsg(), "제 이름은");
        Assertions.assertEquals(chatDtos.get(2).getMsg(), "성창규");
        Assertions.assertEquals(chatDtos.get(3).getMsg(), "입니다.");
    }
}
