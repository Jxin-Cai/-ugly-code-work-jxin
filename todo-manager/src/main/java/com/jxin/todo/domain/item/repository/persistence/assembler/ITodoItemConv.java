package com.jxin.todo.domain.item.repository.persistence.assembler;

import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.repository.persistence.data.TodoItemDO;
import org.mapstruct.Mapper;

/**
 * 待执行项 转换器
 * @author 素律
 * @since 2021/1/2 3:47 下午
 */
@Mapper(componentModel = "spring")
public interface ITodoItemConv {
    /**
     * 领域对象转do
     * @param  todoItem 待执行项 领域实体(聚合根)
     * @return 待执行项 数据项
     */
    TodoItemDO baseDomain2Do(TodoItem todoItem);
    /**
     * 领域对象转do
     * @param  todoItem 待执行项 领域实体(聚合根)
     * @return 待执行项 数据项
     */
    default TodoItemDO domain2Do(TodoItem todoItem){
        final TodoItemDO todoItemDO = baseDomain2Do(todoItem);
        todoItemDO.setStatusType(todoItem.getStatusType());
        return todoItemDO;
    }

    /**
     * do转领域对象
     * @param  todoItemDO 待执行项 数据项
     * @return 待执行项 领域实体(聚合根)
     */
    TodoItem baseDo2Domain(TodoItemDO todoItemDO);

    /**
     * do转领域对象
     * @param  todoItemDO 待执行项 数据项
     * @return 待执行项 领域实体(聚合根)
     */
    default TodoItem do2Domain(TodoItemDO todoItemDO){
        final TodoItem todoItem = baseDo2Domain(todoItemDO);
        todoItem.setStatus(todoItemDO.getStatusType());
        return todoItem;
    }
}
