package com.jxin.todo.domain.item.service;

/**
 * 完成执行项(场景) 领域服务
 * @author 素律
 * @since 2021/1/2 4:26 下午
 */
public interface IDoneItemService {
    /**
     * 完成执行项
     * @param todoItemIdx todo项 索引
     */
    void done(Integer todoItemIdx);
}
