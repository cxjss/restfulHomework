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
     * @return
     */
    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    /**
     * 插入
     * @return
     */
    @PostMapping("/tasks")
    public String insertTask(@RequestBody String body){
        return "insertTask";
    }

    /**
     * 根据id查任务
     * @param id
     * @return
     */
    @GetMapping("/tasks/{id}")
    public String getTaskById(@PathVariable("id") String id){
        return "getTaskById";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable("id") String id){
        return "deleteTask";
    }

    /**
     * 修改
     * @param id
     * @return
     */
    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable("id") String id){
        return "updateTask";
    }



}
