package cn.zqwei.flashkill.service;

import cn.zqwei.flashkill.bo.GoodsBo;

import java.util.List;

public interface FlashKillGoodsService {
    List<GoodsBo> getSeckillGoodsList();

    GoodsBo getFlashKillGoodsBoByGoodsId(long goodsId);

    int reduceStock(long goodsId);
}
