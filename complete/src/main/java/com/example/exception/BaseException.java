package com.example.exception;

import com.example.Messages;

public class BaseException extends Exception {

    private static final long serialVersionUID = -6049202119680643288L;

    private String errorCode;

    private String errorDesc;

    public BaseException(String errorCode, Object... args) {
        super("[" + errorCode + "] " + Messages.getString(errorCode, args));

        this.errorCode = errorCode;
        this.errorDesc = Messages.getString(errorCode, args);
    }

    public BaseException(String errorCode, Throwable t, Object... args) {
        super("[" + errorCode + "] " + Messages.getString(errorCode, args), t);

        this.errorCode = errorCode;
        this.errorDesc = Messages.getString(errorCode, args);
    }

    /**
     * @Deprecated;
     */
    public BaseException(String errorCode, String errorDesc) {
        super("[" + errorCode + "] " + errorDesc);

        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    /**
     * @Deprecated;
     */
    public BaseException(String errorCode, String errorDesc, Throwable t) {
        super("[" + errorCode + "] " + errorDesc, t);

        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

}
