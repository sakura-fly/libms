package com.libmss.model;

import java.util.List;

public class ResponseModel<T> {
    private int code;
    private String msg;
    private T model;
    private List<T> data;
    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public ResponseModel(int code, String msg, T model, List<T> data, long count) {

        this.code = code;
        this.msg = msg;
        this.model = model;
        this.data = data;
        this.count = count;
    }

    public ResponseModel() {

    }

    public int getCode() {
        return code;

    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", model=" + model +
                ", data=" + data +
                ", statistics=" + count +
                '}';
    }
}
