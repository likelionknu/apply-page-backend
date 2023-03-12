package com.springboot.applypage.service;

import com.springboot.applypage.data.dto.ChatDto;

import java.util.List;

public interface ChatService {
    ChatDto saveChat(ChatDto chatDto);
    List<ChatDto> getChat();
}
