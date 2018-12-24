package com.cjf.modelapi.mapper;

import com.cjf.modelapi.model.Goods;
import feign.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {


    int deleteByPrimaryKey(Integer gid);

    int insert(Goods record);

    int insertSelective(Goods record);


    Goods selectByPrimaryKey(Integer gid);


    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}