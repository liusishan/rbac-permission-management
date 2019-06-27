package cn.king.common.inter;
                                 
import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:00
 * @title:
 * @description: 基础的Service, 所有的Service都要实现这个接口
 */
public interface BaseService<T> {

    /**
     * 保存操作
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 删除操作
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除操作
     * @param
     */
    int delete(List<T> records);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();

    /**
     * 分页
     * @param t
     * @param pageNumber
     * @param limit
     * @return
     */
    Map<String,Object> paging(T t, Integer pageNumber, Integer limit);

    /**
     * 根据条件查询总数
     * @param t
     * @return
     */
    Long findCount(T t);

}
