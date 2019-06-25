package cn.king;

import cn.king.entities.User;
import cn.king.mapper.PermissionMapper;
import cn.king.mapper.UserMapper;
import cn.king.utils.PasswordUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    private List<User> getUserList() {
        User user1 = new User();
        user1.setUsername("张三");
        User user2 = new User();
        user2.setUsername("李四");
        User user3 = new User();
        user3.setUsername("王五");
        User user4 = new User();
        user4.setUsername("赵六");
        User user5 = new User();
        user5.setUsername("田七");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        return userList;
    }

    @Test
    public void fun1() {
        List<User> userList = getUserList();
        System.out.println(userList);
        for (User user : userList) {
            user.setSalt("123");
        }
        System.out.println(userList);
    }

    @Test
    public void fun2() {
        System.out.println("________________________________________________");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String format = df.format(new Date());
        System.out.println(format);
    }

    @Test
    public void fun3() {
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

    @Test
    public void fun4() {
        //System.out.println(permissionMapper.findAllPermissions());
        System.out.println(permissionMapper.findAllPermissions());
    }

    @Test
    public void fun5() {
        System.out.println(PasswordUtils.passwordEncode("root" + "f96d8cce6f334e5a8bf3"));
        System.out.println(PasswordUtils.passwordEncode("king" + "8d59e54d29ae4f7fa341"));
        System.out.println(PasswordUtils.passwordEncode("queen" + "fa091bdedff94c3bbf6f"));
        System.out.println(PasswordUtils.passwordEncode("zhangsan" + "871148841d6d4061b816"));
        System.out.println(PasswordUtils.passwordEncode("lisi" + "281a80ac84a4408da2d7"));
        System.out.println(PasswordUtils.passwordEncode("wangwu" + "7eb02a4fac1f4c79bad6"));
        System.out.println(PasswordUtils.passwordEncode("zhaoliu" + "333a1b53969443cf87a3"));
        System.out.println(PasswordUtils.passwordEncode("tianqi" + "674d7c439c274b978c29"));
        System.out.println(PasswordUtils.passwordEncode("zhaoyun" + "b8703ee402bf4527b938"));
        System.out.println(PasswordUtils.passwordEncode("lvbu" + "1605ea19b968465997f6"));
        System.out.println(PasswordUtils.passwordEncode("guanyu" + "c79a3cc042a6465ab698"));
        System.out.println(PasswordUtils.passwordEncode("zhangfei" + "cf1e4e94befe43eea125"));
    }

    @Test
    public void fun6() {
        for (int i = 0; i < 12; i++) {
            System.out.println(PasswordUtils.getSalt());
        }
    }

}
