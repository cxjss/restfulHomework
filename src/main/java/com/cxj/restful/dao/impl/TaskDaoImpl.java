package com.cxj.restful.dao.impl;

import com.alibaba.fastjson.JSON;
import com.cxj.restful.dao.ITaskDao;
import com.cxj.restful.domain.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl implements ITaskDao {

    private Resource resource = new ClassPathResource("static/data.json");

    @Override
    public List<Task> getTasks() {
        if(resource.exists()){
            try {
                InputStream is = resource.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line=br.readLine())!=null){
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
        return 0;
    }

    @Override
    public Task getTaskById(int id) {
        return null;
    }

    @Override
    public int deleteTask(int id) {
        return 0;
    }

    @Override
    public int updateTask(Task task) {
        return 0;
    }
}
