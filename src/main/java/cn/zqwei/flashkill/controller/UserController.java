package cn.zqwei.flashkill.controller;

import cn.zqwei.flashkill.entity.User;
import cn.zqwei.flashkill.service.UserService;
import cn.zqwei.flashkill.vo.LoginParam;
import cn.zqwei.flashkill.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 登录接口（测试：手机号18077200000，密码传入前端加密后的结果：inputPassToFormPass("123456") → 698d51a19d8a121ce581499d7b701668）
    @PostMapping("/login")
    public Result<User> login(@RequestBody LoginParam loginParam) {
        return userService.login(loginParam);
    }
}
