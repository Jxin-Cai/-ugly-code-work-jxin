package com.jxin.todo.domain.item.repository.persistence.impl.mem;

import com.google.common.collect.Maps;
import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.repository.ITodoItemRepository;
import com.jxin.todo.domain.item.repository.persistence.assembler.ITodoItemConv;
import com.jxin.todo.domain.item.repository.persistence.data.TodoItemDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 待执行项聚合 仓储接口 基于内存的实现
 * @author 素律
 * @since 2021/1/2 3:43 下午
 */
@Repository
public class MemTodoItemRepository implements ITodoItemRepository {
    /**本地内存的持久化容器*/
    private static final Map<Integer, TodoItemDO> PERSISTENCE_MAP = Maps.newConcurrentMap();
    private static final AtomicInteger SEQUENCE = new AtomicInteger();
    private final ITodoItemConv todoItemConv;

    public MemTodoItemRepository(ITodoItemConv todoItemConv) {
        this.todoItemConv = todoItemConv;
    }

    @Override
    public int save(TodoItem todoItem) {
        final TodoItemDO todoItemDO = todoItemConv.domain2Do(todoItem);
        todoItemDO.setId(SEQUENCE.incrementAndGet());
        PERSISTENCE_MAP.put(todoItemDO.getId(), todoItemDO);
        return todoItemDO.getId();
    }

    @Override
    public void update(TodoItem todoItem) {
        final TodoItemDO todoItemDO = getTodoItemDOById(todoItem.getId());
        if(todoItem.getName() != null){
            todoItemDO.setName(todoItem.getName());
        }
        if(todoItem.getStatus() != null){
            todoItemDO.setStatusType(todoItem.getStatusType());
        }
    }




    @Override
    public List<TodoItem> todoItemListByStatus(Integer status) {
        return PERSISTENCE_MAP.values().stream()
                                       .filter(todoItemDO -> todoItemDO.getStatusType().equals(status))
                                       .map(todoItemConv::do2Domain)
                                       .collect(Collectors.toList());

    }

    @Override
    public List<TodoItem> todoItemList() {
      return PERSISTENCE_MAP.values().stream()
                                     .map(todoItemConv::do2Domain)
                                     .collect(Collectors.toList());
    }

    @Override
    public Optional<TodoItem> queryById(Integer id) {
        final TodoItemDO todoItemDOById = getTodoItemDOById(id);
        return Optional.of(todoItemConv.do2Domain(todoItemDOById));
    }

    /**
     * 根据id获取待执行项的数据项
     * @param  id id
     * @return 待执行项 数据项
     * @throws IllegalAccessError 要更新的行数据不存在
     */
    private TodoItemDO getTodoItemDOById(Integer id) {
        final Optional<TodoItemDO> todoItemOpt = Optional.ofNullable(PERSISTENCE_MAP.get(id));
        assert todoItemOpt.isPresent() : "要更新的待执行项不存在";
        return todoItemOpt.get();
    }
}
