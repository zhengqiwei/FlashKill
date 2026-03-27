package cn.zqwei.flashkill.service.impl;

import cn.zqwei.flashkill.dao.UserMapper;
import cn.zqwei.flashkill.entity.User;
import cn.zqwei.flashkill.service.UserService;
import cn.zqwei.flashkill.util.MD5Util;
import cn.zqwei.flashkill.vo.LoginParam;
import cn.zqwei.flashkill.vo.Result;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> login(LoginParam loginParam) {
        // 1. 参数校验
        if (loginParam == null || StringUtils.isEmpty(loginParam.getMobile()) || StringUtils.isEmpty(loginParam.getPassword())) {
            return Result.error("参数不能为空");
        }
        // 2. 查询用户
        User user = userMapper.checkPhone(loginParam.getMobile());
        if (user == null) {
            return Result.error("手机号不存在");
        }
        // 3. 校验密码（前端传入的是表单密码，需和数据库密码比对）
        String dbPwd = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(loginParam.getPassword(), saltDB);
        if (!StringUtils.equals(dbPwd, calcPass)) {
            return Result.error("密码错误");
        }
        // 4. 隐藏密码，返回用户信息
        user.setPassword(null);
        return Result.success(user);
    }
}
