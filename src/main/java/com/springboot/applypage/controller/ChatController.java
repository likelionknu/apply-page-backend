package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.ChatDto;
import com.springboot.applypage.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    private final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping()
    public ResponseEntity<List<ChatDto>> getChats(HttpServletRequest request){

        List<ChatDto> chats = chatService.getChat();

        LOGGER.info("호출 API: " + "get chats" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(chats);
    }

    @PostMapping
    public ResponseEntity<ChatDto> insertChat(@RequestBody ChatDto chatDto, HttpServletRequest request){
        ChatDto savedChat = chatService.saveChat(chatDto);

        LOGGER.info("호출 API: " + "insert chat" + " 접속자 IP: " + request.getRemoteAddr() + ", 최초 접속 시간: " +  LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.OK).body(savedChat);
    }
}
