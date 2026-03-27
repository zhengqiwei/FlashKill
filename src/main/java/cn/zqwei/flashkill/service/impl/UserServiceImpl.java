package cn.zqwei.flashkill.service.impl;

import cn.zqwei.flashkill.dao.UserMapper;
import cn.zqwei.flashkill.entity.User;
import cn.zqwei.flashkill.result.CodeMsg;
import cn.zqwei.flashkill.service.UserService;
import cn.zqwei.flashkill.util.MD5Util;
import cn.zqwei.flashkill.vo.LoginParam;
import cn.zqwei.flashkill.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result login(LoginParam loginParam) {

        User user = userMapper.checkPhone(loginParam.getMobile());
        if(user == null){
            return Result.error(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPwd= user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(loginParam.getPassword(), saltDB);
        if(!org.apache.commons.lang3.StringUtils.equals(dbPwd , calcPass)){
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        user.setPassword(StringUtils.EMPTY);
        return Result.success(user);
    }
}
