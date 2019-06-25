package cn.king.entities;

import cn.king.common.model.BaseModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wjl@king.cn
 * @createTime: 2019/6/14 16:24
 * @title:
 * @description:
 */
// 打印父类的toString
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseModel {
    private Integer id;
    /**
     * zTree要求数据中必须有"name",
     * 否则此处我会写成 "permissionName";
     */
    private String name;
    private Integer parentId;
    private String url;
    private String icon;
    private String type;
    private Integer orderNum;

    //已下是zTree要求的数据:
    //树默认是全展开的 -- zTree要求的数据
    private boolean open = true;
    //子节点 -- zTree要求的数据
    private List<Permission> children = new ArrayList<>();
    //菜单前的选框,false代表没勾选. 添加该属性, 用于判断菜单前的选框是否被选中
    private boolean checked = false;

}

