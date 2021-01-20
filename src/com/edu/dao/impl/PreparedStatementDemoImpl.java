package com.edu.dao.impl;

import com.edu.dao.BaseDao;
import com.edu.dao.PreparedStatementDemo;

import java.sql.*;
import java.util.Date;

/**
 * @Auther:haha
 * @Date:2021/1/20 - 01 - 20 15:53
 * @Description:com.edu.dao
 * @Version: 1.0
 */
/*使用jdbc增删改查 实现PreparedStatementDemo接口
 * */
public class PreparedStatementDemoImpl extends BaseDao implements PreparedStatementDemo {

    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;



    //增加新闻信息
    public void addNews(int id, int categoryId, String title, String summary, String content, String author, Date createDate) {


        //PreparedStatement
        try {

//            2.sql命令
            String sql = "insert into news_detail(id, categoryId, title, summary, content,  author, createDate)values(?,?,?,?,?,?,?)";

//            3.statement/preparedStatement
           Object[] params={id, categoryId, title, summary, content,  author, new Timestamp(createDate.getTime())};
           //调用增删改的方法
          int i= this.addDelUpdate(sql,params);
            if (i > 0) {
                System.out.println("插入成功");
                this.getAllNewsByTitle();
            } else {
                System.out.println("插入失败");
            }
        } finally {
            //            5.释放资源
            this.closeResource();
        }
    }

    //删除特定新闻的方法
    public void deleteNews(int id) {
        //PreparedStatement
        try {

//            2.sql命令
            String sql = "delete from news_detail where  id =?";

//            3.statement/preparedStatement
            Object[] params={id};
//            4.返回结果集resultSet
            int i =this.addDelUpdate(sql,params);
            if (i > 0) {
                System.out.println("删除成功");
                this.getAllNewsByTitle();
            } else {
                System.out.println("删除失败");
            }
        } finally {
            //            5.释放资源
           this.closeResource();
        }
    }

    //修改特定新闻标题的方法
    public void updateNews(int id, String ti) {
        //PreparedStatement
        try {

//            2.sql命令
            String sql = "update news_detail set title = ? where id=?";

//            3.statement/preparedStatement
         Object[] params={ti,id};
//            4.返回结果集resultSet
            int i = this.addDelUpdate(sql,params);
            if (i > 0) {
                System.out.println("修改成功");
                this.getAllNewsByTitle();
            } else {
                System.out.println("修改失败");
            }
        }  finally {
            //            5.释放资源
           this.closeResource();
        }
    }

    //查询群不新闻信息的方法
    public void getAllNewsByTitle() {

        try {

//            2.sql命令
            String sql = "select id, categoryId, title, summary, content,  author, createDate from news_detail";

//            3.statement/preparedStatement
         Object[] params={};

//            4.返回结果集resultSet
            rs =this.selectSql(sql,params);
            while (rs.next()) {
                int id = rs.getInt("id");
                int categoryId = rs.getInt("categoryId");
                String title = rs.getString("title");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Timestamp createDate = rs.getTimestamp("createDate");
                System.out.println(id + "\t" + categoryId + "\t" + title + "\t" + summary + "\t" + content + "\t" + author + "\t" + createDate);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            5.释放资源
           this.closeResource();
        }
    }

    //查询特定的标题新闻信息
    public void getNewsByTitle(String ti) {

        try {

//            2.sql命令
            String sql = "select id ,title from news_detail  where title like?";

//            3.statement/preparedStatement
         Object[] params={ti};
//            4.返回结果集resultSet
            rs = this.selectSql(sql,params);
            while (rs.next()) {
                int id = rs.getInt("id");
                String newstitle = rs.getString("title");
                System.out.println("id:" + id + "title:" + newstitle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            5.释放资源
           this.closeResource();
        }
    }




}
