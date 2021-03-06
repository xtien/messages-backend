/*
 * Zaphod Consulting BV demo notification system
 * Copyright (c) 2019, Zaphod Consulting BV, Christine Karman
 * mailto: christine AT christine DOT nl
 *
 * This project is free software: you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0.
 *
 * You can find a copy of the license at
 * http://www. apache.org/licenses/LICENSE-2.0.
 */

package com.loqli.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * User: christine
 * Date: 12/16/18 10:06 PM
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class Application {

    public static final String UI_HOST_LOCAL = "http://pengo.christine.nl:3000";
    public static final String UI_HOST_REMOTE = "https://www.loqli.com";

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
