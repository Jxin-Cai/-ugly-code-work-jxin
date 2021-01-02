package com.jxin.todo.domain.item.service;

import com.jxin.todo.domain.item.aggregation.TodoItem;

import java.util.List;

/**
 * 查看执行项(场景) 领域服务
 * @author 素律
 * @since 2021/1/2 4:26 下午
 */
public interface IReadItemService {
    /**
     * 查看todo项
     * @param all 是否返回全量数据
     */
    List<TodoItem> itemList(boolean all);
}
