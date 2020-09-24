package com.a.afrosin.course.java.core.app;

public class MyArrayDataException extends NumberFormatException{
    private int errorRowNumber;
    private int errorColNumber;
    private String errorElementValue;
    private String errorMessage;

    public MyArrayDataException(int errorRowNumber, int errorColNumber, String errorElementText, String errorMessage) {
        this.errorRowNumber = errorRowNumber;
        this.errorColNumber = errorColNumber;
        this.errorElementValue = errorElementText;
        this.errorMessage = errorMessage;
    }
    public int getErrorRowNumber() {
        return errorRowNumber;
    }

    public int getErrorColNumber() {
        return errorColNumber;
    }

    public String getErrorElementValue() {
        return errorElementValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
