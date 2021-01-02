package com.jxin.todo.domain.item.factory;

import com.jxin.todo.domain.item.aggregation.TodoItem;

/**
 * 待执行项 聚合 工厂类
 * @author 素律
 * @since 2021/1/2 2:48 下午
 */
public interface ITodoItemFactory {
    /**
     * 新建 待执行项聚合
     * @param  name     执行项名称
     * @return 待执行项聚合
     */
    TodoItem newTodoItem(String name);

    /**
     * 封装 待执行项聚合
     * @param  id id
     * @return 待执行项聚合
     */
    TodoItem warpTodoItem(Integer id);

}
