package com.imooc.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2023-04-07.
 * <h1>通用相应对象定义</h1>
 * {
 *     "code":0,
 *     "message":"",
 *     "data":{}
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable{
    /**错误码*/
    private Integer code;
    /**错误消息*/
    private String message;
    /**泛型响应数据*/
    private T data;

    public CommonResponse(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
