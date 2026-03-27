package cn.zqwei.flashkill.vo;

import cn.zqwei.flashkill.bo.GoodsBo;
import cn.zqwei.flashkill.entity.User;
import lombok.Getter;
import lombok.Setter;

//展示对象
@Setter
@Getter
public class GoodDetailVo {
    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private GoodsBo goods ;
    private User user;
}
