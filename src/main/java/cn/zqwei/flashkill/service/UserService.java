package cn.zqwei.flashkill.service;

import cn.zqwei.flashkill.entity.User;
import cn.zqwei.flashkill.vo.LoginParam;
import cn.zqwei.flashkill.result.Result;

public interface UserService {
    Result<User> login(LoginParam loginParam);
}
