package com.cjf.take_order.mapper;

import com.cjf.modelapi.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoMapper {


    int deleteByPrimaryKey(Integer userid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);


    Userinfo selectByPrimaryKey(Integer userid);


    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}