package com.cxj.restful.controller;

import com.cxj.restful.domain.Task;
import com.cxj.restful.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    ITaskService taskService = null;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    /**
     * 插入
     *
     * @return
     */
    @PostMapping("/tasks")
    public String insertTask(@RequestBody Task task) {
        if (taskService.insertTask(task) == 0) {
            return "添加失败";
        }
        return "添加成功";
    }

    /**
     * 根据id查任务
     *
     * @param id
     * @return
     */
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Integer id) {
        return taskService.getTaskById(id);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable("id") Integer id) {
        if (taskService.deleteTask(id) == 0) {
            return "删除失败";
        }
        return "删除成功";
    }

    /**
     * 修改
     *
     * @param task
     * @return
     */
    @PutMapping("/tasks")
    public String updateTask(@RequestBody Task task) {
        if (taskService.updateTask(task) == 0) {
            return "修改失败";
        }
        return "修改成功";
    }


}
