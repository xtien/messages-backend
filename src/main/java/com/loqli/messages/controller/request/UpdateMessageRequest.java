/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loqli.messages.model.Message;

public class UpdateMessageRequest {

    @JsonProperty("message")
    private Message message;

    public UpdateMessageRequest(Message message) {
        this.message = message;
    }
    public UpdateMessageRequest() {
     }

    public Message getMessage() {
        return message;
    }
}