package com.zxl.dailypractice.project.exception;

/**
 * @author: zhaoxl
 * @date: 2022/10/21
 * @desc:
 **/
public class WformException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //警告提示
    public static int WARN = 1;

    //http session 超时代码
    public static int SESSION_TIMEOUT = -504;

    //异常代码 默认值0 表示运行出错
    private int exceptionNo;

    //异常信息
    private String exceptionMsg;

    public WformException() {
        super();
    }

    public WformException(String message) {
        super(message);
        this.exceptionMsg = message;
        this.printStackTrace();
    }

    public WformException(int exceptionNo, String message) {
        this(message);
        this.exceptionNo = exceptionNo;
        this.printStackTrace();
    }

    public WformException(int exceptionNo,String message, Throwable cause) {
        this(message, cause);
        this.exceptionNo = exceptionNo;
        this.printStackTrace();
    }

    public WformException(Throwable cause) {
        super(cause);
    }

    public WformException(String message, Throwable cause) {
        super(message, cause);
        this.exceptionMsg = message;
    }

    public int getExceptionNo() {
        return exceptionNo;
    }

    public void setExceptionNo(int exceptionNo) {
        this.exceptionNo = exceptionNo;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
