package com.jxin.todo;

import com.jxin.todo.infrastructure.plug.db.annotation.EnableMutilDb;
import com.jxin.todo.infrastructure.plug.db.consts.PersistentTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启动类
 * @author Jxin
 * @version 1.0
 * @since 2020/12/29 16:02
 */
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableMutilDb(type = PersistentTypeEnum.MYBATIS)
@Slf4j
public class TodoManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoManagerApplication.class, args);
    }
}
