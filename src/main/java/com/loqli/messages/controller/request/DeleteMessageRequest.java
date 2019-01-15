package com.loqli.messages.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteMessageRequest {

    @JsonProperty("id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
