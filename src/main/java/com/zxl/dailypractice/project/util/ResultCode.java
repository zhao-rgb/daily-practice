package com.zxl.dailypractice.project.util;

/**
 * @author: zhaoxl
 * @date: 2022/10/14
 * @desc:
 **/
public enum  ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 通用错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    HTTP_METHOD_ERROR(10005, "请求方法错误"),
    HTTP_METHOD_NOT_ALLOWED(10006, "请求方法不允许"),
    HTTP_NOT_FOUND(10007, "请求地址错误"),
    BOUND_STATEMENT_NOT_FOUND(10008, "Mybatis未绑定"),
    CONNECTION_ERROR(10009, "网络连接错误"),
    ARITHMETIC_ERROR(100010, "计算错误"),


    /* 用户错误：20001-29999*/
    USER_INPUT_ERROR(20000, "用户名输入错误或验证码错误"),
    USER_NOT_SIGN_IN(20001, "请先登录"),
    USER_PASSWORD_ERROR(20002, "密码错误"),
    USER_ACCOUNT_ERROR(20003, "账号错误"),
    USER_VERIFY_CODE_ERROR(20004, "验证码错误"),
    USER_CODE_TIMEOUT(20005, "验证码失效"),
    USER_ACCOUNT_FORBIDDEN(20006, "账号已被禁用"),
    USER_SIGN_UP_FAIL(20007, "用户注册失败"),
    USER_SIGN_IN_FAIL(20008, "用户登录失败"),
    USER_NOT_FOUND(20009, "用户不存在"),
    USER_FOUND(200012, "用户已经存在"),
    USER_NO_AUTH(20019, "用户权限不足"),
    USER_TOKEN_EXPIRES(200010, "Token已过期"),
    USER_AUTH_ERROR(200011, "用户认证失败"),


    /* 业务错误：30001-39999 */
    SMS_ERROR(30001, "短信业务出现问题"),
    UPLOAD_ERROR(30002, "上传文件业务出现问题"),
    CAPTCHA_ERROR(30003, "验证码业务出现问题"),
    /* 数据错误：40001-49999 */
    RESULT_CODE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATABASE_ERROR(50004, "数据库操作异常"),
    DATABASE_EXPORT_ERROR(50005, "数据导出异常"),


    /* 服务器或系统错误：50001-599999 */
    SERVER_ERROR(50000, "服务器错误，请稍后重试"),
    SYSTEM_ERROR(40001, "系统错误，请稍后重试"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001,"无访问权限");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
