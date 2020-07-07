package com.xiaoxiao.springcloud.alibaba.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiaoyu
 * @date 2020/7/5 - 11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//状态码
    private String message;//携带信息
    private T data;//携带信息

    //创建一个空data的构造方法
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
