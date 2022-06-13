package com.atzhahui.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhahui
 * @creat -05-29 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T   data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
