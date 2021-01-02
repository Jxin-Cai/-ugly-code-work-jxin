package com.jxin.todo.ohs;

/**
 * todo管理服务
 * @author 素律
 * @since 2020/12/31 3:51 下午
 */

public interface ITodoManagerService {
    /**
     * 添加todo项
     * @param todoItem todo项
     */
    String add(String todoItem);

    /**
     * 结束todo项
     * @param itemIdx todo项索引(key)
     */
    String done(Integer itemIdx);

    /**
     * 查看todo项
     * @param all 是否返回全量数据
     */
    String list(boolean all);
}
