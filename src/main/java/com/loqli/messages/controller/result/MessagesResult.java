/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.controller.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loqli.messages.model.Message;

import java.util.Collection;
import java.util.List;

public class MessagesResult extends ApiResult {

    @JsonProperty("messages")
    private List<Message> messages;

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Collection<Message> getMessages() {
        return messages;
    }
}
