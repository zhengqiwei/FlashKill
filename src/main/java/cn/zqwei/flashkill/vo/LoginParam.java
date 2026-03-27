package cn.zqwei.flashkill.vo;

import lombok.Data;

//登录参数类
@Data
public class LoginParam {
    private String mobile; // 手机号
    private String password; // 密码（前端加密后）
}
