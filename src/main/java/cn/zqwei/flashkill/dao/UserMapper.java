package cn.zqwei.flashkill.dao;

import cn.zqwei.flashkill.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    // 根据手机号查询用户
    @Select("SELECT * FROM user WHERE phone = #{phone}")
    User checkPhone(@Param("phone") String phone);
}
