package com.tact.car.exception;

public class GarageException extends Exception {

    /** ID serialized*/
    private static final long serialVersionUID = -4471418799771829748L;

    public GarageException(String msg) {
        super(msg);
    }

    public GarageException(StockException e) {
        super(e);
    }

}
