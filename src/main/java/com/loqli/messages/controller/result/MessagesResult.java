package com.loqli.messages.controller.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loqli.messages.model.Message;

import java.util.Collection;
import java.util.List;

public class MessagesResult extends ApiResult {

    private int result;

    @JsonProperty("messages")
    private List<Message> messages;

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Collection<Message> getMessages() {
        return messages;
    }
}
