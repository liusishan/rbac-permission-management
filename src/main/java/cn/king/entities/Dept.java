package cn.king.entities;
                                                                                                                        
import cn.king.common.model.BaseModel;
import lombok.*;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:25
 * @title:
 * @description:
 */
// 打印父类的toString
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends BaseModel{
    private Integer id;
    private String deptName;
    private Integer parentId;
}
