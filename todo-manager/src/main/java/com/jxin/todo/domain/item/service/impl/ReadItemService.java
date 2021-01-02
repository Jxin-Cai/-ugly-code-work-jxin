package com.jxin.todo.domain.item.service.impl;

import com.jxin.todo.domain.item.aggregation.ItemStatusEnum;
import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.repository.ITodoItemRepository;
import com.jxin.todo.domain.item.service.IReadItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查看执行项(场景) 领域服务
 * @author 素律
 * @since 2021/1/2 4:37 下午
 */
@Service
public class ReadItemService implements IReadItemService {
    @Autowired
    private ITodoItemRepository todoItemRepository;
    @Override
    public List<TodoItem> itemList(boolean all) {
       if (all){
           return todoItemRepository.todoItemList();
       }
       return todoItemRepository.todoItemListByStatus(ItemStatusEnum.UNDONE.getType());
    }
}
