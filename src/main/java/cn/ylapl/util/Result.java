package cn.ylapl.util;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 返回值封装类
 *
 * @author Angle
 * @date 2017/3/3
 */
@Data
@Accessors(chain = true)
@Slf4j
public class Result<T> implements Serializable{
    private int code;
    private T object;
    private String error;
    private String message;
    private Exception exception;

    /**
     * 判断返回结果是否成功 0是失败 1是成功
     */
    public boolean isSuccess() {
        return code == 0;
    }

    /**
     * 判断返回结果是否有结果对象
     */
    public boolean hasObject() {
        return code == 0 && object != null;
    }

    /**
     * 判断返回结果是否有异常
     */
    public boolean hasException() {
        return exception != null;
    }

    /**
     * 接口调用成功，不需要返回对象
     */
    public static <T> Result<T> newSuccess() {
        Result<T> result = new Result<>();
        result.setCode(1);
        return result;
    }

    /**
     * 接口调用成功，有返回对象
     */
    public static <T> Result<T> newSuccess(T object) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setObject(object);
        return result;
    }

    /**
     * 接口调用失败，有错误码和描述，没有返回对象
     */
    public static <T> Result<T> newFailure(int code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code != 0 ? code : -1);
        result.setMessage(message);
        return result;
    }

    /**
     * 接口调用失败，有错误字符串码和描述，没有返回对象
     */
    public static <T> Result<T> newFailure(String error, String message) {
        Result<T> result = new Result<>();
        result.setCode(-1);
        result.setError(error);
        result.setMessage(message);
        return result;
    }

    /**
     * 转换或复制错误结果
     */
    public static <T> Result<T> newFailure(Result<?> failure) {
        Result<T> result = new Result<>();
        result.setCode(failure.getCode() != 0 ? failure.getCode() : -1);
        result.setError(failure.getError());
        result.setMessage(failure.getMessage());
        result.setException(failure.getException());
        return result;
    }

    /**
     * 接口调用失败，返回异常信息
     */
    public static <T> Result<T> newException(Exception e) {
        Result<T> result = new Result<>();
        result.setCode(-1);
        result.setException(e);
        result.setMessage(e.getMessage());
        return result;
    }
}
