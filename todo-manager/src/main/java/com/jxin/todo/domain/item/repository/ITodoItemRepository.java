package com.jxin.todo.domain.item.repository;

import com.jxin.todo.domain.item.aggregation.TodoItem;

import java.util.List;
import java.util.Optional;

/**
 * 待执行项聚合 仓储接口
 * @author 素律
 * @since 2021/1/2 3:08 下午
 */
public interface ITodoItemRepository {
    /**
     * 存储 待执行项聚合
     * @param  todoItem 待执行项(聚合根)
     */
    int save(TodoItem todoItem);

    /**
     * 修改待执行项
     * @param todoItem 待执行项(聚合根)
     */
    void update(TodoItem todoItem);

    /**
     * 获取 待执行项列表
     * @param  status 状态值
     * @return 待执行项 领域实体(聚合根) 列表
     */
    List<TodoItem> todoItemListByStatus(Integer status);
    /**
     * 获取 待执行项列表
     * @return 待执行项 领域实体(聚合根) 列表
     */
    List<TodoItem> todoItemList();

    /**
     * 根据id获取 待执行项
     * @param  id id
     * @return 待执行项 领域实体(聚合根)
     */
    Optional<TodoItem> queryById(Integer id);
}
