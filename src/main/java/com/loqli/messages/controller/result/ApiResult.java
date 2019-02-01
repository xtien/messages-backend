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

public class ApiResult {

    public static final int OK = 0;
    public static final int NOT_OK = -1;

    private int resultCode;

    public void setResult(int result) {
        this.resultCode = result;
    }

    public int getResultCode() {
        return resultCode;
    }
}
