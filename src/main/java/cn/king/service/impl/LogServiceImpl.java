package cn.king.service.impl;

import cn.king.entities.Log;
import cn.king.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:54
 * @title:
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {

    @Override
    @Transactional
    public int insert(Log record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(Log record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<Log> records) {
        return 0;
    }

    @Override
    public Log findById(Integer id) {
        return null;
    }


    @Override
    public List<Log> findAll() {
        return null;
    }

    @Override
    public Map<String, Object> paging(Log log, Integer pageNumber, Integer limit) {
        return null;
    }

    @Override
    public Long findCount(Log log) {
        return null;
    }
}
