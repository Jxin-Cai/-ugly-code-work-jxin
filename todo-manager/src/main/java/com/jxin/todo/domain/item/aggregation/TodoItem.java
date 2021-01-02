package com.jxin.todo.domain.item.aggregation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 待执行项 领域实体(聚合根)
 * @author 素律
 * @since 2021/1/1 7:03 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoItem implements ITodoItem {
    /**id(索引项)*/
    private Integer id;
    /**执行项名称*/
    private String name;
    /**状态枚举类*/
    private ItemStatusEnum status;


    /**
     * 完结执行项
     */
    @Override
    public void doneItem(){
        status = ItemStatusEnum.DONE;
    }

    @Override
    public boolean isDone() {
        return ItemStatusEnum.DONE.equals(status);
    }

    @Override
    public Integer getStatusType() {
        return status.getType();
    }

    @Override
    public void setStatus(Integer statusType) {
        this.status = ItemStatusEnum.getByType(statusType).orElseThrow(() -> ItemAggreExcepotion.of("状态类型不存在"));
    }
}
