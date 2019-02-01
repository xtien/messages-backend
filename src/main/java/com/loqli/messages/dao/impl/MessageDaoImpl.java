/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.dao.impl;

import com.loqli.messages.dao.MessageDao;
import com.loqli.messages.model.Message;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    Logger logger = Logger.getLogger(MessageDaoImpl.class);

    @PersistenceContext(unitName = "defaultPU")
    private EntityManager em;

    public MessageDaoImpl() {
        // needed for deserialization
    }

    @Override
    public List<Message> getMessages() {

        TypedQuery<Message> query = em.createQuery(
                "select a from " + Message.class.getSimpleName()
                        + " a order by a.id",
                Message.class);

        return query.getResultList();
    }

    @Override
    public int create(Message message) {

        em.persist(message);
        return 0;
    }

    @Override
    public Message getMessageById(int id) {
        return em.find(Message.class, id);
    }

    @Override
    public int deleteMessages(List<Message> messages) {

        try {
            for (Message l : messages) {
                deleteMessage(l.getId());
            }
        } catch (Exception e) {
            logger.error("Error deleting messages", e);
            return -1;
        }

        return 0;

    }

    @Override
    public int deleteMessage(int id) {

        int result = -1;

        try {
            Message message = em.find(Message.class, id);
            if(message !=null){
                em.remove(message);
                result = 0;
            }
        } catch (Exception e) {
            logger.error("Error deleting message", e);
        }

        return result;
    }
}
