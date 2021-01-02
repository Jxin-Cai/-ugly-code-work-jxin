package com.jxin.todo.domain.item.aggregation;

/**
 * 待执行项聚合 行为接口
 * @author 素律
 * @since 2021/1/2 2:44 下午
 */
public interface ITodoItem {
    /**
     * 完结执行项
     */
    void doneItem();

    /**
     * 状态是否已经完结
     * @return 是返回 true
     */
    boolean isDone();
    /**
     * 获取状态类型
     * @return 状态类型
     */
    Integer getStatusType();

    /**
     * 赋值状态值
     * @param statusType 状态类型
     */
    void setStatus(Integer statusType);
}
