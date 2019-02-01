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

import com.loqli.messages.Application;
import com.loqli.messages.controller.request.UpdateMessageRequest;
import com.loqli.messages.controller.result.MessageResult;
import com.loqli.messages.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * User: christine
 * Date: 12/29/18 12:41 PM
 */
@Controller
public class UpdateMessageController {

    Logger logger = Logger.getLogger(UpdateMessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = {Application.UI_HOST_LOCAL,Application.UI_HOST_REMOTE})
    @PostMapping(value = "/updateMessage/")
    public ResponseEntity<MessageResult> updateMessage(@RequestBody UpdateMessageRequest request) {

        MessageResult result = new MessageResult();
        result.setResult(MessageResult.NOT_OK);

        try {
            messageService.updateMessage(request.getMessage());

        } catch (Exception e) {
           logger.error("Error updating message", e);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
