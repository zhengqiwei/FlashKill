package cn.zqwei.flashkill.util;

import cn.zqwei.flashkill.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//测试用户生成
public class UserUtil {
    // 数据库连接配置（和application.properties一致）
    private static final String DB_URL = "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "123456";

    // 生成用户并插入数据库
    private static void createUser(int count) throws Exception {
        List<User> users = new ArrayList<>(count);
        // 1. 生成用户数据
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUserName("user" + i);
            user.setPhone((18077200000L + i) + ""); // 手机号：18077200000~18077200999
            user.setSalt("9d5b364d"); // 固定盐值
            user.setPassword(MD5Util.inputPassToDbPass("123456", user.getSalt())); // 密码123456
            user.setLoginCount(1);
            user.setRegisterDate(new Date());
            user.setLastLoginDate(new Date());
            user.setHead("");
            users.add(user);
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        String sql = "INSERT INTO user (user_name, phone, password, salt, head, login_count, register_date, last_login_date) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (User user : users) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPhone());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getSalt());
            pstmt.setString(5, user.getHead());
            pstmt.setInt(6, user.getLoginCount());
            pstmt.setTimestamp(7, new Timestamp(user.getRegisterDate().getTime()));
            pstmt.setTimestamp(8, new Timestamp(user.getLastLoginDate().getTime()));
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        pstmt.close();
        conn.close();
        System.out.println("生成" + count + "个测试用户成功！");
    }

    //测试
    public static void main(String[] args) throws Exception {
        createUser(1000); // 生成1000个用户
    }
}