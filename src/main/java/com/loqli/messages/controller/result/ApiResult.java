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
