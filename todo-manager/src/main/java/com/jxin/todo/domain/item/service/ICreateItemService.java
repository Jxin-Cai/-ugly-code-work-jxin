package com.jxin.todo.domain.item.service;

/**
 * 新建执行项(场景) 领域服务
 * @author 素律
 * @since 2021/1/2 4:26 下午
 */
public interface ICreateItemService {
    /**
     * 创建执行项
     * @param todoItem todo项
     * @return 执行项的id
     */
    Integer create(String todoItem);
}
