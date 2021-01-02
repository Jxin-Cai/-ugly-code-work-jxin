package com.jxin.todo.domain.item.service.impl;

import com.jxin.todo.domain.item.factory.impl.TodoItemFactory;
import com.jxin.todo.domain.item.repository.ITodoItemRepository;
import com.jxin.todo.domain.item.service.ICreateItemService;
import org.springframework.stereotype.Service;

/**
 * 新建执行项(场景) 领域服务
 * @author 素律
 * @since 2021/1/2 4:40 下午
 */
@Service
public class CreateItemService implements ICreateItemService {
    private final ITodoItemRepository todoItemRepository;
    private final TodoItemFactory todoItemFactory;

    public CreateItemService(ITodoItemRepository todoItemRepository, TodoItemFactory todoItemFactory) {
        this.todoItemRepository = todoItemRepository;
        this.todoItemFactory = todoItemFactory;
    }

    @Override
    public Integer create(String todoItem) {
        return todoItemRepository.save(todoItemFactory.newTodoItem(todoItem));
    }
}
