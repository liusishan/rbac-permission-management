package cn.king.common.http;

import cn.king.utils.PagingUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:05
 * @title:
 * @description: 封装响应结果
 */
@Data
public class HttpResult {

    private int code = 200;
    private String msg;
    private Object data;

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/14 16:08
     * @param: []
     * @return: cn.king.common.http.HttpResult
     * @description: 返回500和默认提示消息
     */
    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/14 16:07
     * @param: [msg]
     * @return: cn.king.common.http.HttpResult
     * @description: 返回500和自定义的消息
     */
    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setData(data);
        return r;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

}
