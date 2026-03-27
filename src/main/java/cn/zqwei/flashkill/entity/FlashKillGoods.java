package cn.zqwei.flashkill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

//秒杀商品实体
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlashKillGoods {
    private Long id;

    private Long goodsId;

    private BigDecimal seckillPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;
}
