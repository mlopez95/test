package com.py.api.test.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {

    @JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private String statusCode;
    @JsonProperty("uri")
    private String uriRequested;

    public ErrorInfo(APIException exception, String uriRequested) {
        this.message = exception.getMessage();
        this.statusCode = exception.getCode();
        this.uriRequested = uriRequested;
    }

    public ErrorInfo(String statusCode, String message, String uriRequested) {
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }

    public String getMessage() {
        return message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getUriRequested() {
        return uriRequested;
    }

}
