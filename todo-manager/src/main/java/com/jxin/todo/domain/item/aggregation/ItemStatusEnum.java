package com.jxin.todo.domain.item.aggregation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 执行项状态枚举类
 * @author 素律
 * @since 2021/1/2 2:26 下午
 */
@AllArgsConstructor
public enum ItemStatusEnum {
    /**实例列表*/

    UNDONE("未完成", "",0),
    DONE("完成", "[Done]",1);

    /**状态名称*/
    @Getter
    private String name;
    /**展示信息*/
    @Getter
    private String showMsg;
    /**状态类型*/
    @Getter
    private Integer type;

    private static final Map<Integer, ItemStatusEnum> TYPE_MAP;

    static {
        TYPE_MAP = Arrays.stream(ItemStatusEnum.values()).collect(Collectors.toMap(ItemStatusEnum::getType, itemStatusEnum -> itemStatusEnum));
    }

    static Optional<ItemStatusEnum> getByType(Integer type){
        return Optional.ofNullable(TYPE_MAP.get(type));
    }
}
