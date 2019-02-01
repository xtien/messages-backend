/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages.model;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.Collection;

/**
 * User: christine
 * Date: 1/15/19 11:57 AM
 */
@Entity
@Table(name = "users")
@EnableJpaRepositories(
        basePackages = "com.loqli.messages.dao")
public class User {

    public final static String USER_ID = "user_id";
    public final static String ORGANIZATION_ID = "organization_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Message> messages;

    @Column(name = USER_ID)
    private String userId;

    @Column(name = ORGANIZATION_ID)
    private String organizationId;
}
