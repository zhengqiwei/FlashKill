package cn.zqwei.flashkill.controller;

import cn.zqwei.flashkill.bo.GoodsBo;
import cn.zqwei.flashkill.entity.FlashKillGoods;
import cn.zqwei.flashkill.result.Result;
import cn.zqwei.flashkill.service.FlashKillGoodsService;
import cn.zqwei.flashkill.vo.GoodDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private FlashKillGoodsService flashKillGoodsService;

    @GetMapping("/list")
    private Result<List<GoodsBo>> list(){
        List<GoodsBo> goodsBos = flashKillGoodsService.getSeckillGoodsList();
        return Result.success(goodsBos);
    }
}
