package com.cjf.take_order8002.service;

import com.cjf.modelapi.model.Goods;
import com.cjf.take_order8002.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/24 11:49
 **/
@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    GoodsMapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int GoodsNumReduce(Goods goods) {
        try {
            int num = mapper.selectByPrimaryKey(goods.getGid()).getGoodsnum();
            if (num > 1) {
                goods.setGoodsnum(goods.getGoodsnum() - 1);
            }
            return mapper.updateByPrimaryKeySelective(goods);
        } catch (Exception e) {
            return 0;
        }
    }
}
