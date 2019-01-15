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