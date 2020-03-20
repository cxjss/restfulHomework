package com.cxj.restful.dao;

import com.cxj.restful.domain.Task;

import java.util.List;

public interface ITaskDao {
    /**
     * 查询所有
     * @return
     */
    List<Task> getTasks();

    /**
     * 插入
     * @param task
     * @return
     */
    int insertTask(Task task);

    /**
     * 根据id查任务
     * @param id
     * @return
     */
    Task getTaskById(int id);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteTask(int id);

    /**
     * 修改
     * @param task
     * @return
     */
    int updateTask(Task task);
}
