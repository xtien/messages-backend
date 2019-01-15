/*
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.service.impl;

import com.loqli.messages.dao.MessageDao;
import com.loqli.messages.service.MessageService;
import com.loqli.messages.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.LocalDate.now;

public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    Logger log = Logger.getLogger(MessageServiceImpl.class);

    @Override
    @Transactional
    public Message getMessageById(int messageNumber) {
        return messageDao.getMessageById(messageNumber);
    }

    @Override
    @Transactional
    public List<Message> getMessages() {
        return messageDao.getMessages();
    }

    @Override
    @Transactional
    public int updateMessage(Message message) {
        int result = -1;
        try {
            Message existingMessage = getMessageById(message.getId());
            if (existingMessage != null) {
                existingMessage.setHeader(message.getHeader());
                existingMessage.setText(message.getText());
                existingMessage.setStatus(message.getStatus());
                existingMessage.setDateEntered(now());
            }
            result = 0;
        } catch (Exception e) {
            log.error(e);
        }
        return result;
    }

    @Override
    @Transactional
    public int addMessage(Message message) {
        if (message.hasId()) {
            return updateMessage(message);
        } else {
            message.setDateEntered(now());
            return messageDao.create(message);
        }
    }

    @Override
    @Transactional
    public int deleteMessage(int id) {
        return messageDao.deleteMessage(id);
    }
}
