package com.a.afrosin.course.java.core.app;

public class MyArraySizeException extends IndexOutOfBoundsException{
    private int errorSize;
    private String errorMessage;

    public int getErrorSize() {
        return errorSize;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public MyArraySizeException(int errorSize, String errorMessage) {
        this.errorSize = errorSize;
        this.errorMessage = errorMessage;
    }
}
