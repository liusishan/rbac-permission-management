package cn.king.service.impl;

import cn.king.entities.Dept;
import cn.king.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:40
 * @title:
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Override
    @Transactional
    public int insert(Dept record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(Dept record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<Dept> records) {
        return 0;
    }

    @Override
    public Dept findById(Integer id) {
        return null;
    }


    @Override
    public List<Dept> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> paging(Dept dept, Integer pageNumber, Integer limit) {
        return null;
    }


    @Override
    public Long findCount(Dept dept) {
        return null;
    }
}
