package com.xiaoxiao.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Xiaoyu
 * @date 2020/7/6 - 9:06
 */
@Mapper
public interface StorageDao {
    /**
     * 减少库存
     */
    public void decrease(@Param("productId") Long productId, @Param("residue") Integer residue);

    /*
    增加已用库存
     */
    public void increase(@Param("productId") Long productId, @Param("used") Integer used);

    /**
     * 获取产品库存数量
     *
     * @param productId
     * @return
     */
    public Integer getResidue(@Param("productId") Long productId);

    /**
     * 获取产品已用数量
     *
     * @param productId
     * @return
     */
    public Integer getUsed(@Param("productId") Long productId);
}
