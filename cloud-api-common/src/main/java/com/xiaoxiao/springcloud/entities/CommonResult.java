package com.xiaoxiao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 8:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//返回的状态码
    private String message;//错误信息
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
