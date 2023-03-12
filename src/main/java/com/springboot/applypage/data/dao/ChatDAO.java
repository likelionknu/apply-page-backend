package com.springboot.applypage.data.dao;

import com.springboot.applypage.data.entity.Chat;

import java.util.List;

public interface
ChatDAO {
    Chat insertChat(Chat chat);
    List<Chat> getChats();
}
