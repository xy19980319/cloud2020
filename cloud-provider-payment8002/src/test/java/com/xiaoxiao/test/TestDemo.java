package com.xiaoxiao.test;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author Xiaoyu
 * @date 2020/6/25 - 22:58
 */
public class TestDemo {
    @Test
    public void testTime() {
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }
}
