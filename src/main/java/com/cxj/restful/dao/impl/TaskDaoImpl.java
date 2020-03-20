package com.cxj.restful.dao.impl;

import com.alibaba.fastjson.JSON;
import com.cxj.restful.dao.ITaskDao;
import com.cxj.restful.domain.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.annotation.Target;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl implements ITaskDao {

    String jsonPath = "src/main/resources/static/data.json";
    private Resource resource = new ClassPathResource("static/data.json");

    public void writeJson(String path, List<Task> list) {
        String str = JSON.toJSONString(list);
        PrintStream stream = null;
        try {
            stream = new PrintStream(path);//写入的文件path
            stream.print(str);//写入的字符串
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getTasks() {
        if (resource.exists()) {
            try {
                InputStream is = resource.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                List<Task> tasks = JSON.parseArray(sb.toString(), Task.class);
                return tasks;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int insertTask(Task task) {
        List<Task> list = getTasks();
        for (Task originTask : list) {
            if (originTask.getId() == task.getId()) {
                return 0;
            }
        }
        list.add(task);
        writeJson(jsonPath,list);
        return 1;
    }

    @Override
    public Task getTaskById(int id) {
        List<Task> list = getTasks();
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public int deleteTask(int id) {
        List<Task> list = getTasks();
        for (Task originTask : list) {
            if (originTask.getId() == id) {
                list.remove(originTask);
                writeJson(jsonPath,list);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateTask(Task task) {
        List<Task> list = getTasks();
        for (Task originTask : list) {
            if (originTask.getId() == task.getId()) {
                originTask.setContent(task.getContent());
                originTask.setCreatedTime(task.getCreatedTime());
                writeJson(jsonPath,list);
                return 1;
            }
        }
        return 0;
    }
}
