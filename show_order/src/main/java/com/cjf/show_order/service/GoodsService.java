package com.cjf.show_order.service;

import com.cjf.modelapi.model.Goods;
import com.cjf.modelapi.model.Orders;

import java.util.List;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/29 17:20
 **/
public interface GoodsService {
    List<Goods> showAllGoods();
}
