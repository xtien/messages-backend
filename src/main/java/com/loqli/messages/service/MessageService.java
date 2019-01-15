package com.loqli.messages.service;

import com.loqli.messages.model.Message;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageService {

    @Transactional
    Message getMessageById(int messageNumber);

    @Transactional
    List<Message> getMessages();

    @Transactional
    int updateMessage(Message message);

    int addMessage(Message message);

    int deleteMessage(int id);
}
