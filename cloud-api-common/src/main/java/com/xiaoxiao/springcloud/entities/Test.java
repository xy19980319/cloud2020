package com.xiaoxiao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiaoyu
 * @date 2020/6/21 - 11:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private Integer id ;
    private String name;
    private String money;
}
