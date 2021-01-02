package com.jxin.todo.domain.item.repository.persistence.impl.file.mapper;

import com.jxin.todo.domain.item.repository.persistence.data.TodoItemDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 素律
 * @since 2021/1/2 10:25 下午
 */
public interface TodoItemDOMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(TodoItemDO record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(TodoItemDO record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    TodoItemDO selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TodoItemDO record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TodoItemDO record);

    List<TodoItemDO> selectAllByStatusType(@Param("statusType")Integer statusType);
    List<TodoItemDO> findAll();





}