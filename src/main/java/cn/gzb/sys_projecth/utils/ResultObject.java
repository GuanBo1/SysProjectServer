package cn.gzb.sys_projecth.utils;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class ResultObject {
    private String code;
    private String message;
    private Object data;
    public ResultObject(){}
    public ResultObject(String code,String message,Object data){
        this.data = data;
        this.code = code;
        this.message = message;
    }
    public ResultObject(String code,String message){
        this.data = null;
        this.code = code;
        this.message = message;
    }
}
