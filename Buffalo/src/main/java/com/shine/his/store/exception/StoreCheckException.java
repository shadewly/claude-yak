package com.shine.his.store.exception;

import com.shine.his.common.exception.HISException;

/**
 * Created by claude on 15-7-8.
 */
public class StoreCheckException extends HISException {

    public StoreCheckException() {
        super();
    }


    public StoreCheckException(Exception e) {
        super(e);
    }

    public StoreCheckException(String message) {
        super(message);
    }

    public StoreCheckException(String message, Exception e) {
        super(message, e);
    }
}
