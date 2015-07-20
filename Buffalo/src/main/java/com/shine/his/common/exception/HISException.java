package com.shine.his.common.exception;

/**
 * Created by claude on 15-6-30.
 */
public class HISException extends Exception {
    private static final long serialVersionUID = 8670135969660230761L;

    public HISException() {
        super();
    }


    public HISException(Exception e) {
        super(e);
    }

    public HISException(String message) {
        super(message);
    }

    public HISException(String message, Exception e) {
        super(message, e);
    }
}
