package com.edu.dao;

import java.sql.*;
import java.util.Date;

/**
 * @Auther:haha
 * @Date:2021/1/20 - 01 - 20 15:53
 * @Description:com.edu.dao
 * @Version: 1.0
 */
/*使用jdbc增删改查  3-DAO模式及单例模式
 * */
public class DAOdemo {

    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    //获取数据库链接的方法
    public void getConnection() {

        try {
            // class.forName(String) 加载不同数据库厂商提供的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //1.获取链接 connection
            String url = "jdbc:mysql://localhost:3306/kgcnews?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //增加新闻信息
    public void addNews(int id, int categoryId, String title, String summary, String content, String author, Date createDate) {


        //PreparedStatement
        try {
            //获取数据库链接的方法
            this.getConnection();
//            2.sql命令
            String sql = "insert into news_detail(id, categoryId, title, summary, content,  author, createDate)values(?,?,?,?,?,?,?)";

//            3.statement/preparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, categoryId);
            pstmt.setString(3, title);
            pstmt.setString(4, summary);
            pstmt.setString(5, content);
            pstmt.setString(6, author);
            pstmt.setTimestamp(7, new Timestamp(createDate.getTime()));
//            4.返回结果集resultSet
            int i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
                this.getAllNewsByTitle();
            } else {
                System.out.println("插入失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            5.释放资源
            try {
                connection.close();
                pstmt.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //删除特定新闻的方法
    public void deleteNews(int id) {
        //PreparedStatement
        try {
            //获取数据库链接的方法
            this.getConnection();
//            2.sql命令
            String sql = "delete from news_detail where  id =?";

//            3.statement/preparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

//            4.返回结果集resultSet
            int i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
                this.getAllNewsByTitle();
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            5.释放资源
            try {
                connection.close();
                pstmt.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //修改特定新闻标题的方法
    public void updateNews(int id, String ti) {
        //PreparedStatement
        try {
            //获取数据库链接的方法
            this.getConnection();
//            2.sql命令
            String sql = "update news_detail set title = ? where id=?";

//            3.statement/preparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, ti);
            pstmt.setInt(2, id);


//            4.返回结果集resultSet
            int i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
                this.getAllNewsByTitle();
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            5.释放资源
            try {
                connection.close();
                pstmt.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //查询群不新闻信息的方法
    public void getAllNewsByTitle() {

        try {
            //获取数据库链接的方法
            this.getConnection();
//            2.sql命令
            String sql = "select id, categoryId, title, summary, content,  author, createDate from news_detail";

//            3.statement/preparedStatement
            pstmt = connection.prepareStatement(sql);

//            4.返回结果集resultSet
            rs = pstmt.executeQuery();
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
            try {
                connection.close();
                pstmt.close();
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //查询特定的标题新闻信息
    public void getNewsByTitle(String ti) {

        try {
            //获取数据库链接的方法
            this.getConnection();
//            2.sql命令
            String sql = "select id ,title from news_detail  where title like?";

//            3.statement/preparedStatement
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, ti);
//            4.返回结果集resultSet
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String newstitle = rs.getString("title");
                System.out.println("id:" + id + "title:" + newstitle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //            5.释放资源
            try {
                connection.close();
                pstmt.close();
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        DAOdemo pd = new DAOdemo();
//        //查询全部
        pd.getAllNewsByTitle();
        System.out.println("======================================================================================");
//        //指定查询
//        pd.getNewsByTitle("Java" + "%");
//        //新增
//        pd.addNews(3, 2, "hhhhhh", "dddddd", "dddddd", "dddddd", new Date());
//        System.out.println("======================================================================================");
//        //修改
//        pd.updateNews(3,"我笑了呀 手术室护士水水水水");
//        System.out.println("======================================================================================");
        //删除
        pd.deleteNews(4);


    }


}
