package cn.king.utils;

import cn.king.common.model.BaseModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/19 9:55
 * @title:
 * @description: 分页工具类
 */
public class PagingUtils {

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 9:57
     * @param: [data, count]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @description: 只用来封装分页数据中的"数据"和"总数"
     */
    public static Map<String, Object> pagingData(List<? extends BaseModel> data, Long count) {
        Map<String, Object> pagDatas = new HashMap<>();
        pagDatas.put("data", data);
        pagDatas.put("count", count);
        return pagDatas;
    }

}
