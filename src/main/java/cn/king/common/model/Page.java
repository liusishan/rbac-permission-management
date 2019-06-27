package cn.king.common.model;
                                                                                   
import lombok.Data;
import java.util.List;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 19:11
 * @title:
 * @description: 封装所有关于分页的数据
 */
@Data
public class Page<T> {
    /**
     * 当前页码
     */
    private Integer pageNumber;
    /**
     * 总页码
     */
    private Integer totalPageNumber;
    /**
     * 总记录数
     */
    private Integer totalRecordsSize;
    /**
     * 分页数据
     */
    private List<T> data;
}


