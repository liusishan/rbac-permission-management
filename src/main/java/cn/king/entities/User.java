package cn.king.entities;

import cn.king.common.model.BaseModel;
import lombok.*;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:19
 * @title:
 * @description:
 */
// 打印父类的toString
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel {
    private Integer id;
    private String username;
    /**
     * 账号
     */
    private String loginAccount;
    private String password;
    private String email;
    private String salt;
    /**
     * 状态. 0:禁用; 1:正常; 数据库默认1.
     */
    private Integer status;


}
