package cn.king.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 17:01
 * @title:
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {
    private String account;
    private String password;
    private String captcha;
}
