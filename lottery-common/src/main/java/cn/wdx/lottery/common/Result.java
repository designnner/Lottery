package cn.wdx.lottery.common;

import java.io.Serializable;

/**
 * @author: wdxxx
 * @description: TODO
 * @date: 2024/3/6 8:33 PM
 * @version: 1.0
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -3826891916021780628L;

    private String code;
    private String info;

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public static Result buildResult(String code,String info){
        return new Result(code,info);
    }

    public static Result buildSuccessResult(){
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildErrorResult(){
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
    }

    public static Result buildErrorResult(String info){
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), info);
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
