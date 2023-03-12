package com.springboot.applypage.data.dao.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.springboot.applypage.data.dao.ChatDAO;
import com.springboot.applypage.data.entity.Chat;
import com.springboot.applypage.data.entity.QChat;
import com.springboot.applypage.data.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ChatDAOImpl implements ChatDAO {

    @PersistenceContext
    EntityManager entityManager;

    ChatRepository chatRepository;

    @Autowired
    public ChatDAOImpl(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat insertChat(Chat chat) {

        Chat savedChat = chatRepository.save(chat);

        return savedChat;
    }

    @Override
    public List<Chat> getChats() {

        JPAQuery<Chat> query = new JPAQuery(entityManager);
        QChat qChat = QChat.chat;
        List<Chat> chats = query
                .from(qChat)
                .orderBy(qChat.cid.desc())
                .limit(4)
                .fetch();
        return chats;
    }
}
