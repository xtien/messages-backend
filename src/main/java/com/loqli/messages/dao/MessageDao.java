package com.loqli.messages.dao;

import com.loqli.messages.model.Message;

import java.util.List;

public interface MessageDao {

    List<Message> getMessages();

    int create(Message message);

    Message getMessageById(int id);

    int deleteMessages(List<Message> messages);

    int deleteMessage(int id);
}
