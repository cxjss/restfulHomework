package com.cxj.restful.service.impl;

import com.cxj.restful.dao.ITaskDao;
import com.cxj.restful.domain.Task;
import com.cxj.restful.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskDao taskDao = null;

    @Override
    public List<Task> getTasks() {
        return taskDao.getTasks();
    }

    @Override
    public int insertTask(Task task) {
        return taskDao.insertTask(task);
    }

    @Override
    public Task getTaskById(int id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public int deleteTask(int id) {
        return taskDao.deleteTask(id);
    }

    @Override
    public int updateTask(Task task) {
        return taskDao.updateTask(task);
    }
}
