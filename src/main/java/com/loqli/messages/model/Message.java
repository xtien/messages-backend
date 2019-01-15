/*
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * This project is free software: you can redistribute it and/or modify it under the terms of
 * the Apache License, Version 2.0. You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "messages")
@EnableJpaRepositories(
        basePackages = "com.loqli.messages.dao")
public class Message {

    private static final String STATUS = "status";
    private static final String TEXT = "text";
    private static final String HEADER = "header";
    public static final String DATE_FROM = "dateFrom";
    public static final String DATE_UNTIL = "dateUntil";
    public static final String DATE_ENTERED = "dateEntered";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = STATUS)
    @JsonProperty(STATUS)
    private int status;

    @Column(name = HEADER)
    @JsonProperty(HEADER)
    private String header;

    @Column(name = TEXT)
    @JsonProperty(TEXT)
    private String text;

    @Column(name = DATE_FROM)
    @JsonProperty(DATE_FROM)
    private LocalDate dateFrom;

    @Column(name = DATE_UNTIL)
    @JsonProperty(DATE_UNTIL)
    private LocalDate dateUntil;

    @Column(name = DATE_ENTERED)
    @JsonIgnore
    private LocalDate dateEntered;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "letter_sender",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private Collection<User> users;

    public Message() {
    }

    public Message(int status, String text) {

        this.status = status;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean hasId() {
        return id != 0;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setId(int id){
        this.id = id;
    }
}
