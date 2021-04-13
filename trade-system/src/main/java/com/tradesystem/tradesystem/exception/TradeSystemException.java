package com.tradesystem.tradesystem.exception;

public class TradeSystemException extends RuntimeException{

    public TradeSystemException() {
        super();
    }

    public TradeSystemException(final String message, final Throwable cause) {

        super(message, cause);
    }

    public TradeSystemException(final String message) {

        super(message);
    }

    public TradeSystemException(final Throwable cause) {

        super(cause);
    }
}
