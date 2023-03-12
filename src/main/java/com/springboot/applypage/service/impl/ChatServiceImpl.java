package com.springboot.applypage.service.impl;

import com.springboot.applypage.data.dao.ChatDAO;
import com.springboot.applypage.data.dto.ChatDto;
import com.springboot.applypage.data.entity.Chat;
import com.springboot.applypage.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    ChatDAO chatDAO;
    @Autowired
    public ChatServiceImpl(ChatDAO chatDAO){
        this.chatDAO = chatDAO;
    }

    @Override
    public ChatDto saveChat(ChatDto chatDto) {
        Chat chat = new Chat();
        chat.setMsg(chatDto.getMsg());

        Chat savedChat = chatDAO.insertChat(chat);
        ChatDto responseChat = new ChatDto();
        responseChat.setMsg(savedChat.getMsg());

        return responseChat;
    }

    @Override
    public List<ChatDto> getChat() {

        List<Chat> chats = chatDAO.getChats();
        List<ChatDto> chatDto = new LinkedList<>();

        for (Chat chat:chats) {
            ChatDto buffChatDto = new ChatDto();
            buffChatDto.setMsg(chat.getMsg());
            chatDto.add(buffChatDto);
        }

        return chatDto;
    }
}
