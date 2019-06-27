package cn.king.entities;
                                                                          
import cn.king.common.model.BaseModel;
import lombok.*;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:31
 * @title:
 * @description:
 */
// 打印父类的toString
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends BaseModel {
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
