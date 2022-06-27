package com.wdke.stock.common.enums;

public enum ResponseStatusEnum {
    SUCCESS(200, "成功"),
    LOGOUT(300, "未登录"),
    NO_PERMISSIONS(300, "用户没有权限操作此接口"),
    USER_ERROR(301, "用户名不存在"),
    PASSWORD_ERROR(302, "密码错误"),
    USER_ISLIVE(303, "用户名已存在"),
    PHONE_ISLIVE(304, "手机号已经注册。"),
    EMAIL_ISLIVE(305, "邮箱已经注册。"),
    DATA_DB_ISLIVE(306, "数据库信息已存在。"),
    ERROR(201, "请求错误"),
    PARRAM_ERROR(202, "参数错误"),
    DATA_REPETITION(203, "参数错误"),
    DATA_EMPTY(200, "数据为空"),
    DATA_ISLIVE(200, "数据已经存在"),
    TABLES_EMPTY(204, "数据表不存在或已经被删除"),
    COLUMNS_EMPTY(204, "数据表字段不存在"),
    INVALID_TOKEN(4001, "失效的token");


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
