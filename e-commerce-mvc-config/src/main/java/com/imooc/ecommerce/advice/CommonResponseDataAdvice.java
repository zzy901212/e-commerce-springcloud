package com.imooc.ecommerce.advice;

import com.imooc.ecommerce.annotation.IgnoreResponseAdvice;
import com.imooc.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by Administrator on 2023-04-07.
 * <h1>实现统一响应</h1>
 */
@RestControllerAdvice(value = "com.imooc.ecommerce")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object>{
    /**
     * <h2>判断是否需要对响应进行处理</h2>
     * */
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
       /*如果这个注解存在的话，忽略相应*/
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }
    /**
     * <h2></h2>
     *
     * */
    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //定义最终的返回对象
        CommonResponse<Object> response = new CommonResponse<Object>(0, "");
        if(null==o){
            return response;
        }else if(o instanceof CommonResponse){
            response=(CommonResponse<Object>) o;
        }else{
            response.setData(o);
        }
        return response;
    }
}
