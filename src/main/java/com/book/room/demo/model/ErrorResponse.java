package com.book.room.demo.model;

import java.util.Objects;

public class ErrorResponse {

    private int status;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return status == that.status &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, status);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
