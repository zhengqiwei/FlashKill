package cn.zqwei.flashkill.service.impl;

import cn.zqwei.flashkill.bo.GoodsBo;
import cn.zqwei.flashkill.dao.GoodsMapper;
import cn.zqwei.flashkill.service.FlashKillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FlashKillGoodsService")
public class FlashKillGoodsServiceImpl implements FlashKillGoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return goodsMapper.selectAllGoodes();
    }

    @Override
    public GoodsBo getFlashKillGoodsBoByGoodsId(long goodsId) {
        return goodsMapper.getseckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    public int reduceStock(long goodsId) {
        return goodsMapper.updateStock(goodsId);
    }
}
