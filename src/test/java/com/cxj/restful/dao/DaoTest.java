package com.cxj.restful.dao;

import com.cxj.restful.dao.impl.TaskDaoImpl;
import com.cxj.restful.domain.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DaoTest {

    @Test
    public void testGetTasks(){
        ITaskDao taskDao = new TaskDaoImpl();
        List<Task> tasks = taskDao.getTasks();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    @Test
    public void testGetTaskById(){
        ITaskDao taskDao = new TaskDaoImpl();
        Task task = taskDao.getTaskById(3);
        System.out.println(task);
    }

    @Test
    public void testInsertTask(){
        ITaskDao taskDao = new TaskDaoImpl();
        taskDao.insertTask(new Task(3,"51,",""));
    }
}
