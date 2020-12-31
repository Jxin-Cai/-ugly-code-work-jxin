package com.jxin.todo.ohs.impl;

import com.jxin.todo.ohs.TodoManagerService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

/**
 * todo管理服务 实现
 * @author 素律
 * @since 2020/12/31 3:57 下午
 */
@ShellComponent("todo")
public class TodoManagerServiceImpl implements TodoManagerService {
    /**命令统一前缀*/
    private static final String PRE_CMD = "todo ";
    @ShellMethod(value = "Add todo.", group = "todoManager", key = PRE_CMD + "add")
    @Override
    public String add(String todoItem) {
        return todoItem;
    }
    @ShellMethod(value = "Done todo.", group = "todoManager", key = PRE_CMD + "done")
    @Override
    public String done(Integer itemIdx) {
        return Optional.ofNullable(itemIdx).orElse(-1) + "";
    }
    @ShellMethod(value = "Query todo item list.", group = "todoManager", key = PRE_CMD + "list")
    @Override
    public String list(boolean all) {
       return String.valueOf(all);
    }
}
