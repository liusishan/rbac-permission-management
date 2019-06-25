package cn.king.service.impl;

import cn.king.entities.User;
import cn.king.mapper.UserMapper;
import cn.king.service.UserService;
import cn.king.utils.BaseFieldsSetValueUtils;
import cn.king.utils.IPUtils;
import cn.king.utils.PagingUtils;
import cn.king.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public int insert(User record) {

        return 0;
    }

    @Override
    @Transactional
    public int delete(User record) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(List<User> records) {
        return 0;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/25 18:11
     * @param: [user]
     * @return: cn.king.entities.User
     * @description: 登录查询
     */
    @Override
    public User findUserByLogin(User user) {
        User dbUser = userMapper.findUserByAccount(user.getLoginAccount());
        if (dbUser == null) {
            logger.info("查询的用户数据为空! ");
            return null;
        }
        String password = PasswordUtils.passwordEncode(user.getPassword() + dbUser.getSalt());
        return dbUser.getPassword().equals(password) ? dbUser : null;
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/25 18:11
     * @param: [user, session]
     * @return: java.lang.Integer
     * @description: 添加用户
     */
    @Override
    public Integer insertUser(User user, HttpSession session) {
        String salt = PasswordUtils.getSalt();
        user.setPassword(PasswordUtils.passwordEncode(user.getPassword() + salt));
        Map<String, String> map = BaseFieldsSetValueUtils.setBaseFields(session);
        String by = map.get("by");
        String time = map.get("time");
        user.setCreateBy(by);
        user.setCreateTime(time);
        user.setLastUpdateBy(by);
        user.setLastUpdateTime(time);
        user.setDelFlag(0);
        user.setStatus(1);
        user.setSalt(salt);
        return userMapper.insertUser(user);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 9:23
     * @param: [user, pageNumber, limit]
     * @return: java.util.List<cn.king.entities.User>
     * @description: 分页
     */
    @Override
    public Map<String, Object> paging(User user, Integer pageNumber, Integer limit) {
        List<User> userList = userMapper.userPaging(user, (pageNumber - 1) * limit, limit);
        Long userCount = userMapper.findUserCount(user);
        return PagingUtils.pagingData(userList, userCount);
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2019/6/19 9:28
     * @param: [user]
     * @return: java.lang.Long
     * @description: 根据条件查询用户总数
     */
    @Override
    public Long findCount(User user) {
        return userMapper.findUserCount(user);
    }


}
