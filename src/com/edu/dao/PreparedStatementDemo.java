package com.edu.dao;

import java.sql.*;
import java.util.Date;

/**
 * @Auther:haha
 * @Date:2021/1/20 - 01 - 20 15:53
 * @Description:com.edu.dao
 * @Version: 1.0
 */
/*使用jdbc增删改查  DAO模式及单例模式-面向接口的DAO设计
 * */
public interface PreparedStatementDemo {


    //增加新闻信息
    public void addNews(int id, int categoryId, String title, String summary, String content, String author, Date createDate);

    //删除特定新闻的方法
    public void deleteNews(int id);

    //修改特定新闻标题的方法
    public void updateNews(int id, String ti);

    //查询群不新闻信息的方法
    public void getAllNewsByTitle();

    //查询特定的标题新闻信息
    public void getNewsByTitle(String ti);




}
