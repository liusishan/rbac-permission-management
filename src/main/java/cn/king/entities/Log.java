package cn.king.entities;
                                                                                                         
import cn.king.common.model.BaseModel;
import lombok.*;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:51
 * @title:
 * @description:
 */
// 打印父类的toString
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log extends BaseModel {
    private Integer id;
    private String userName;
    private String operation;
    private String method;
    private String params;
    private Long time;
    private String ip;
}
