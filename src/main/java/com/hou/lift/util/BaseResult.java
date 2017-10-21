package com.hou.lift.util;

/**
 * Created with IntelliJ IDEA.
 * User: sigon
 * Date: 14-12-4
 * Time: 上午8:32
 * To change this template use File | Settings | File Templates.
 */
public class BaseResult {
    private Integer code;

    private Boolean status;
    private String msg;
    private Object data;

    public BaseResult(){

    }
    public BaseResult(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
