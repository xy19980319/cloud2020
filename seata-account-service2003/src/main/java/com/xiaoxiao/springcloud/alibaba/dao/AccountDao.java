package com.xiaoxiao.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 9:46
 */
@Mapper
public interface AccountDao {

    /*
    获取用户余额
     */
    public BigDecimal getResidue(@Param("userId") Long userId);

    /*
    获取用户已用金额
    */
    public BigDecimal getUsed(@Param("userId") Long userId);

    /*
    扣除余额
     */
    public void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

    /*
    增加已用余额
     */
    public void increase(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
