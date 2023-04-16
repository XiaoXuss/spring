package com.example.common.webapi;

/**
 * IErrorCode : 封装API错误码
 *
 * @author xab
 * @date 2023/4/10 22:55
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
