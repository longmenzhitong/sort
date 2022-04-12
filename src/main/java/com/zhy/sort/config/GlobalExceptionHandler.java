package com.zhy.sort.config;

import com.zhy.sort.model.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 *
 * @author zhihaoyu
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<?>> handleException(Exception e) {
        log.error("global exception handler:", e);
        return ResponseEntity.ok(Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Result<?>> handleHttpMessageNotReadableException(Exception e) {
        log.error("global exception handler:", e);
        return ResponseEntity.ok(Result.error(HttpStatus.BAD_REQUEST.value(), "请求错误"));
    }
}
