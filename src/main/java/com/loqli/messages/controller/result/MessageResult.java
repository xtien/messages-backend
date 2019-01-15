package com.loqli.messages.controller.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loqli.messages.model.Message;

public class MessageResult extends ApiResult {

    @JsonProperty("message")
    private Message message;

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
