package com.wdke.stock.common.enums;
import java.util.HashSet;

public enum ReturnStatusEnum {

    SC_OK(200, "成功"),

    SC_NOT_MODIFIED(304, "未处理"),

    SC_BAD_REQUEST(400, "服务器不理解请求的语法"),
    
    SC_INTERNAL_SERVER_ERROR(500, "服务器遇到错误"),

    /* API状态码  */
    API_NET_EXCEPTION(521, "网络异常"),

    API_INTERFACE_EXCEPTION(548, "接口调用异常"),

    API_STATUS_ERROR(549, "接口返回状态码错误"),
    
    API_PARAM_INVALID(4002, "参数非法"),
    
    API_NO_PERMISSION(4001, "没有权限"),
    
    API_DATA_INVALID(5001, "数据非法"),
    
    /* JSON数据解析 */
    JSON_ARRAY_PARSE_FAIL(6001, "JSON数组解析失败"),

    JSON_OBJECT_PARSE_FAIL(6002, "JSON对象解析失败");
    
    /** The value. */
    private final int value;

    /** The desc. */
    private final String desc;

    private ReturnStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }
    
    public String getDesc() {
        return desc;
    }

    private static HashSet<Integer> hashSet;

    static {
        hashSet = new HashSet<Integer>();
        hashSet.clear();
        for (ReturnStatusEnum returnStatus : values()) {
            hashSet.add(returnStatus.getValue());
        }
    }

    public static boolean isDefined(int value) {
        if (hashSet.contains(value)) {
            return true;
        }
        return false;
    }
}
