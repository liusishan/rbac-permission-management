package cn.king.entities;
                                                                                                                        
import cn.king.common.model.BaseModel;
import lombok.*;

/**
 * @author: wcj
 */
// 打印父类的toString
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission extends BaseModel {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
}
