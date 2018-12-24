package com.cjf.show_order.mapper;

import com.cjf.modelapi.model.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {


    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);


    Goods selectByPrimaryKey(Integer gid);


    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}