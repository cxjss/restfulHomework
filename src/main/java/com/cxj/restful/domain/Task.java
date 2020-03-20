package com.cxj.restful.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    private int id;
    private String content;
    private String createdTime;
}