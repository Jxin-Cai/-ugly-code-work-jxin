package com.jxin.todo.domain.item.repository.persistence.data;

import java.util.Date;
import lombok.Data;

/**
 * @author 素律
 * @since 2021/1/2 10:25 下午
 */
@Data
public class TodoItemDO {
    private Integer id;

    /**
     * 容器Id
     */
    private String name;

    /**
     * 未完结: 0,完结: 1
     */
    private Integer statusType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}