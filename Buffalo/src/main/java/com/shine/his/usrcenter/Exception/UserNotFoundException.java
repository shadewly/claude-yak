package com.shine.his.usrcenter.Exception;

import com.shine.his.common.exception.HISException;

/**
 * Created by claude on 15-6-30.
 */
public class UserNotFoundException extends HISException {
    public UserNotFoundException(Exception e) {
        super(e);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
