package com.cjf.modelapi.mapper;

import com.cjf.modelapi.model.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {


    int deleteByPrimaryKey(Integer oid);

    int insert(Orders record);

    int insertSelective(Orders record);


    Orders selectByPrimaryKey(Integer oid);


    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectAll();
}