package cn.zqwei.flashkill.dao;

import cn.zqwei.flashkill.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    User selectByPhoneAndPassword(@Param("phone") String phone , @Param("password") String password);

    // 根据手机号查询用户
    User checkPhone(@Param("phone") String phone);
}
