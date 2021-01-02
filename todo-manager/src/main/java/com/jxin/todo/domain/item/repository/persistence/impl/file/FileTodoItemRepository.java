package com.jxin.todo.domain.item.repository.persistence.impl.file;

import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.repository.ITodoItemRepository;
import com.jxin.todo.domain.item.repository.persistence.assembler.ITodoItemConv;
import com.jxin.todo.domain.item.repository.persistence.data.TodoItemDO;
import com.jxin.todo.domain.item.repository.persistence.impl.file.mapper.TodoItemDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 待执行项聚合 仓储接口 基于文件的实现
 * @author 素律
 * @since 2021/1/2 3:43 下午
 */
@Repository
public class FileTodoItemRepository implements ITodoItemRepository {
    private final ITodoItemConv todoItemConv;
    private final TodoItemDOMapper todoItemDOMapper;

    public FileTodoItemRepository(ITodoItemConv todoItemConv, TodoItemDOMapper todoItemDOMapper) {
        this.todoItemConv = todoItemConv;
        this.todoItemDOMapper = todoItemDOMapper;
    }

    @Override
    public int save(TodoItem todoItem) {
        final TodoItemDO todoItemDO = todoItemConv.domain2Do(todoItem);
        todoItemDOMapper.insertSelective(todoItemDO);
        return todoItemDO.getId();
    }

    @Override
    public void update(TodoItem todoItem) {
        final TodoItemDO todoItemDO = todoItemConv.domain2Do(todoItem);
        todoItemDOMapper.updateByPrimaryKeySelective(todoItemDO);
    }

    @Override
    public List<TodoItem> todoItemListByStatus(Integer status) {
        return todoItemDOMapper.selectAllByStatusType(status)
                               .stream()
                               .map(todoItemConv::do2Domain)
                               .collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> todoItemList() {
        return todoItemDOMapper.findAll()
                               .stream()
                               .map(todoItemConv::do2Domain)
                               .collect(Collectors.toList());
    }

    @Override
    public Optional<TodoItem> queryById(Integer id) {
        return Optional.ofNullable(todoItemDOMapper.selectByPrimaryKey(id)).map(todoItemConv::do2Domain);
    }
}
