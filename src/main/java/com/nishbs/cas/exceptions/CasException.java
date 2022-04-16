package com.nishbs.cas.exceptions;


public class CasException extends RuntimeException {
    public CasException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public CasException(String exMessage) {
        super(exMessage);
    }
}
