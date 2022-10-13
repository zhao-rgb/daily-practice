package com.zxl.dailypractice.project.util;

import java.io.Serializable;

/**
 * @author: zhaoxl
 * @date: 2022/10/12
 * @desc:
 **/
public class FileReturn<T> implements Serializable {
    private static final long serialVersionUID = -1959544190118740608L;
    private int resultCode;
    private String msg;
    private T data;

    public FileReturn() {

    }

    public FileReturn(int resultCode, String msg, T data) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileReturn{" +
                "resultCode=" + resultCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
