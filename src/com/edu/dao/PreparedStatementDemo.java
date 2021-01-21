package com.edu.dao;

import com.edu.pojo.News;
import com.edu.pojo.NewsCategory;

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
    //通过数据源获取连接 进行数据库连接 查询新闻
    public void getAllNewsByDs();

    //增加新闻信息
    //老方法
    // public void addNews(int id, int categoryId, String title, String summary, String content, String author, Date createDate);
    public void addNews(News news);

    //删除特定新闻的方法
    //老方法
    // public void deleteNews(int id);
    public void deleteNews(News news);

    //修改特定新闻标题的方法
    // 老方法
    // public void updateNews(int id, String ti);
    public void updateNews(News news);
    //查询群不新闻信息的方法
    public void getAllNewsByTitle();

    //查询特定的标题新闻信息
    //老方法
    // public void getNewsByTitle(String ti);
    public void getNewsByTitle(News news);

    //查询莫格新闻分类下是否有新闻
    public int getCountByCategory(NewsCategory newsCategory);




}
