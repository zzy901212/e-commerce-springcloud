package com.imooc.ecommerce.advice;

import com.imooc.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2023-04-07.
 * <h1>全局异常捕获处理</h1>
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException
            (HttpServletRequest request, Exception ex){
        CommonResponse<String> response = new CommonResponse<String>(-1,"business error");
        response.setData(ex.getMessage());
        log.error("commerce service has error:[{}]",ex.getMessage(),ex);
        return response;
    }
}
