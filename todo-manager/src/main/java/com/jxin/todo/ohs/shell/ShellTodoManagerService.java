package com.jxin.todo.ohs.shell;

import cn.hutool.core.util.StrUtil;
import com.jxin.todo.domain.item.aggregation.TodoItem;
import com.jxin.todo.domain.item.service.ICreateItemService;
import com.jxin.todo.domain.item.service.IDoneItemService;
import com.jxin.todo.domain.item.service.IReadItemService;
import com.jxin.todo.ohs.ITodoManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

/**
 * todo管理服务 实现
 * @author 素律
 * @since 2020/12/31 3:57 下午
 */
@ShellComponent("todo")
public class ShellTodoManagerService implements ITodoManagerService {
    /**命令统一前缀*/
    private static final String PRE_CMD = "todo ";
    /**add命令返回参数模版*/
    private static final String ADD_RET_STR_TMP = "\n {}. <{}> \n\n Item <{}> added";
    /**done命令返回参数模版*/
    private static final String DONE_RET_STR_TMP = "\nItem <{}> done.";
    /**列表单行返回模版*/
    private static final String LIST_ROW_RET_STR_TMP = "{}. <{}> \n";
    /**列表结尾返回模版*/
    private static final String LIST_END_RET_STR_TMP = "\nTotal: {} items";
    /**列表结尾全量类型返回模版*/
    private static final String LIST_END_ALL_RET_STR_TMP = "\nTotal: {} items, {} item done";
    private final IReadItemService readItemService;
    private final IDoneItemService doneItemService;
    private final ICreateItemService createItemService;

    public ShellTodoManagerService(IReadItemService readItemService, IDoneItemService doneItemService, ICreateItemService createItemService) {
        this.readItemService = readItemService;
        this.doneItemService = doneItemService;
        this.createItemService = createItemService;
    }


    @ShellMethod(value = "Add todo.", group = "todoManager", key = PRE_CMD + "add")
    @Override
    public String add(String todoItem) {
        final boolean noneBlank = StringUtils.isNoneBlank(todoItem);
        assert noneBlank : "执行项名称不能为null";
        final Integer idx = createItemService.create(todoItem);
        return StrUtil.format(ADD_RET_STR_TMP, idx, todoItem, idx);
    }
    @ShellMethod(value = "Done todo.", group = "todoManager", key = PRE_CMD + "done")
    @Override
    public String done(Integer itemIdx) {
        final boolean noNull = itemIdx != null;
        assert noNull : "执行项索引值不能为null";
        doneItemService.done(itemIdx);
        return StrUtil.format(DONE_RET_STR_TMP, itemIdx);
    }
    @ShellMethod(value = "Query todo item list.", group = "todoManager", key = PRE_CMD + "list")
    @Override
    public String list(boolean all) {
        final List<TodoItem> todoItems = readItemService.itemList(all);
        final StringBuilder ret = new StringBuilder();
        for (TodoItem todoItem : todoItems) {
            ret.append(StrUtil.format(LIST_ROW_RET_STR_TMP, todoItem.getId(), todoItem.getName()));
        }
        if(all){
            ret.append(StrUtil.format(LIST_END_ALL_RET_STR_TMP,
                       todoItems.size(),
                       todoItems.stream().filter(TodoItem::isDone).count()));
        }else {
            ret.append(StrUtil.format(LIST_END_RET_STR_TMP, todoItems.size()));
        }
        return ret.toString();
    }
}
