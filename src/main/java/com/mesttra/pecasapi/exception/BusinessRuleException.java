package com.mesttra.pecasapi.exception;

import java.io.Serial;

public class BusinessRuleException extends Exception {

    @Serial
    private static final long serialVersionUID = 6618409774546889931L;

    public BusinessRuleException(String message) {
        super(message);
    }
}
