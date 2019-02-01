/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.test.live;

import com.loqli.messages.controller.result.AddMessageResult;
import com.loqli.messages.controller.AddMessageController;
import com.loqli.messages.controller.request.AddMessageRequest;
import com.loqli.messages.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestAddMessage {

    @Autowired
    private AddMessageController addMessageController;

    @Test
    public void testGetMessages() {

        AddMessageRequest addMessageRequest = new AddMessageRequest();
        addMessageRequest.setMessage(new Message(1, "test bericht"));
        ResponseEntity<AddMessageResult> addMessageResult = addMessageController.addMessage(addMessageRequest);
        Assert.assertEquals(HttpStatus.OK, addMessageResult.getStatusCode());
    }
}
