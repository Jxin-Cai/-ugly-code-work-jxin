package com.jxin.todo.domain.item.aggregation;

/**
 * 执行项聚合异常类
 * @author 素律
 * @since 2021/1/2 2:40 下午
 */
class ItemAggreExcepotion extends RuntimeException {

    ItemAggreExcepotion(String msg) {
        super(msg);
    }

    static ItemAggreExcepotion of(String msg) {
        return new ItemAggreExcepotion(msg);
    }
}
