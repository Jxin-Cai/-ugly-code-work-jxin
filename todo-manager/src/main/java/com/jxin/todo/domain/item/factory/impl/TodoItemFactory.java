package com.jxin.todo.domain.item.factory.impl;

import com.jxin.todo.domain.item.aggregation.ITodoItem;
import com.jxin.todo.domain.item.aggregation.ItemStatusEnum;
import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.factory.ITodoItemFactory;
import org.springframework.stereotype.Component;

/**
 *  待执行项 聚合 工厂类
 * @author 素律
 * @since 2021/1/2 2:49 下午
 */
@Component
public class TodoItemFactory implements ITodoItemFactory {
    @Override
    public TodoItem newTodoItem(String name) {
        return TodoItem.builder()
                       .name(name)
                       .status(ItemStatusEnum.UNDONE)
                       .build();
    }

    @Override
    public TodoItem warpTodoItem(Integer id) {
        return TodoItem.builder()
                       .id(id)
                       .build();
    }
}
