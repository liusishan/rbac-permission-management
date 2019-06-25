package cn.king.utils;

import cn.king.entities.User;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/23 17:34
 * @title: 基础字段的赋值工具类
 * @description: 专门用来给
 * createBy, createTime, lastUpdateBy, lastUpdateTime
 * 这几个字段赋值的工具类
 */
public class BaseFieldsSetValueUtils {

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/23 17:43
     * @param: [session]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @description: 添加或修改时的基础字段赋值
     */
    public static Map<String, String> setBaseFields(HttpSession session) {
        // 获取系统当前时间
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // 获取当前登录系统的用户名
        String name = ((User) session.getAttribute("loginUser")).getUsername();
        Map<String, String> map = new HashMap<>();
        map.put("by", name);
        map.put("time", currentTime);
        return map;
    }
}
