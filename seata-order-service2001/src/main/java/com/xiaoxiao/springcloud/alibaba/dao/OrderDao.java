package com.xiaoxiao.springcloud.alibaba.dao;

import com.xiaoxiao.springcloud.alibaba.domian.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Xiaoyu
 * @date 2020/7/5 - 15:14
 */
@Mapper
public interface OrderDao {
    //新建一个订单
    public void create(Order order);
    //更新订单状态
    public void update(@Param("userId") Long userId,@Param("status") Integer status);
}
