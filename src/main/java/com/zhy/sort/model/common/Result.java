package com.zhy.sort.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 通用业务响应
 *
 * @author zhihaoyu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8252350919288654637L;

    /**
     * 响应码
     */
    private int code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .code(HttpStatus.OK.value())
                .msg("成功")
                .data(data)
                .build();
    }

    public static <T> Result<T> error(int code, String msg) {
        return Result.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }
}
