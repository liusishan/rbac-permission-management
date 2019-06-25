package cn.king.service.impl;

import cn.king.entities.RoleDept;
import cn.king.service.RoleDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:41
 * @title:
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleDeptServiceImpl implements RoleDeptService {

    @Override
    @Transactional
    public int insert(RoleDept record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(RoleDept record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<RoleDept> records) {
        return 0;
    }

    @Override
    public RoleDept findById(Integer id) {
        return null;
    }

    @Override
    public List<RoleDept> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> paging(RoleDept roleDept, Integer pageNumber, Integer limit) {
        return null;
    }

    @Override
    public Long findCount(RoleDept roleDept) {
        return null;
    }
}
