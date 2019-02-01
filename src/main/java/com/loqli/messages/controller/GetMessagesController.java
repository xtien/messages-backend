/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.controller;

import com.loqli.messages.controller.result.MessagesResult;
import com.loqli.messages.service.MessageService;
import com.loqli.messages.Application;
import com.loqli.messages.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GetMessagesController {

    Logger logger = Logger.getLogger(GetMessagesController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = {Application.UI_HOST_LOCAL,Application.UI_HOST_REMOTE})
    @GetMapping(value = "/getMessages/")
    public ResponseEntity<MessagesResult> getMessages() {

        MessagesResult result = new MessagesResult();

        try {

            List<Message> messages = messageService.getMessages();
            result.setMessages(messages);
            result.setResult(MessagesResult.OK);

        } catch (Exception e) {
            logger.error("Error getting messages", e);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
