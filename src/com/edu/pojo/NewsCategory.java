package com.edu.pojo;

import java.util.Date;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 20:47
 * @Description:com.edu.pojo
 * @Version: 1.0
 */
//封装数据 新闻类别
public class NewsCategory {
        private int id;
        private String name;
        private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
