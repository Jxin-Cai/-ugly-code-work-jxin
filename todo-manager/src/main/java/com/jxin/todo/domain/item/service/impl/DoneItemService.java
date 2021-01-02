package com.jxin.todo.domain.item.service.impl;

import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.factory.ITodoItemFactory;
import com.jxin.todo.domain.item.repository.ITodoItemRepository;
import com.jxin.todo.domain.item.service.IDoneItemService;
import org.springframework.stereotype.Service;

/**
 * 完成执行项(场景) 领域服务
 * @author 素律
 * @since 2021/1/2 4:44 下午
 */
@Service
public class DoneItemService implements IDoneItemService {
    private final ITodoItemRepository todoItemRepository;
    private final ITodoItemFactory todoItemFactory;

    public DoneItemService(ITodoItemRepository todoItemRepository, ITodoItemFactory todoItemFactory) {
        this.todoItemRepository = todoItemRepository;
        this.todoItemFactory = todoItemFactory;
    }

    @Override
    public void done(Integer todoItemIdx) {
        final TodoItem todoItem = todoItemFactory.warpTodoItem(todoItemIdx);
        todoItem.doneItem();
        todoItemRepository.update(todoItem);
    }
}
