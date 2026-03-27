package cn.zqwei.flashkill.vo;


import lombok.Data;
//结果封装类
@Data
public class Result<T> {
    private int code; // 状态码：0成功，1失败
    private String msg; // 提示信息
    private T data; // 数据

    // 成功（带数据）
    public static <T> Result<T> success(T data) {
        return new Result<>(0, "success", data);
    }

    // 失败（带提示）
    public static <T> Result<T> error(String msg) {
        return new Result<>(1, msg, null);
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
