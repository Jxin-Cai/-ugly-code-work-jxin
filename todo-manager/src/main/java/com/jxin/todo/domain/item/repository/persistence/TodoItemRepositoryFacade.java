package com.jxin.todo.domain.item.repository.persistence;

import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.repository.ITodoItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 待执行项聚合 仓储接口 门面类
 * @author 素律
 * @since 2021/1/2 4:17 下午
 */
@Repository
@Primary
public class TodoItemRepositoryFacade implements ITodoItemRepository {
    @Value("${item.rep.invokeName}")
    private String invokeName;
    private final Map<String, ITodoItemRepository> todoItemRepositoryMap;

    public TodoItemRepositoryFacade(Map<String, ITodoItemRepository> todoItemRepositoryMap) {
        this.todoItemRepositoryMap = todoItemRepositoryMap;
    }

    @Override
    public int save(TodoItem todoItem) {
        return todoItemRepositoryMap.get(invokeName).save(todoItem);
    }

    @Override
    public void update(TodoItem todoItem) {
        todoItemRepositoryMap.get(invokeName).update(todoItem);
    }

    @Override
    public List<TodoItem> todoItemListByStatus(Integer status) {
        return todoItemRepositoryMap.get(invokeName).todoItemListByStatus(status);
    }

    @Override
    public List<TodoItem> todoItemList() {
        return todoItemRepositoryMap.get(invokeName).todoItemList();
    }

    @Override
    public Optional<TodoItem> queryById(Integer id) {
        return todoItemRepositoryMap.get(invokeName).queryById(id);
    }
}
