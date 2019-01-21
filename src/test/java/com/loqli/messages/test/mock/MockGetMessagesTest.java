/*
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.test.mock;

import com.loqli.messages.controller.GetMessagesController;
import com.loqli.messages.model.Message;
import com.loqli.messages.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * User: christine
 * Date: 1/21/19 3:47 PM
 */
@RunWith(SpringRunner.class)
@WebMvcTest(GetMessagesController.class)
public class MockGetMessagesTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService service;

    private List<Message> messages = new LinkedList<>();
    private Message message1 = new Message();

    private String json = "{\"requestCode\":0}";
    private String text = "this my comment";

    @Before
    public void setup() {
        message1.setHeader(text);
        messages.add(message1);
        messages.add(new Message());
    }

    @Test
    public void testGetMessagesMock() throws Exception {
        when(service.getMessages()).thenReturn(messages);
        this.mockMvc.perform(get("/getMessages/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(text)));
    }
}