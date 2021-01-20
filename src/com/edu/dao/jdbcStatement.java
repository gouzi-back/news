package com.edu.dao;


import java.sql.*;

/**
 * @Auther:haha
 * @Date:2021/1/20 - 01 - 20 13:43
 * @Description:com.edu.dao
 * @Version: 1.0
 */
public class jdbcStatement {
        // 查询新闻id标题
        public static void main(String[] args) {
                Connection connection=null;
                Statement stmt=null;
                ResultSet rs=null;
                try {
// class.forName(String) 加载不同数据库厂商提供的驱动
                Class.forName("com.mysql.jdbc.Driver");
//            1.获取链接 connection
                 String url="jdbc:mysql://localhost:3306/kgcnews?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
                connection = DriverManager.getConnection(url, "root", "1234");
//            2.sql命令
                 String sql="select id ,title from news_detail";
//            3.statement/preparedStatement
                   stmt =connection.createStatement();

//            4.返回结果集resultSet
                   rs = stmt.executeQuery(sql);
                  while (rs.next()){
                       int id=   rs.getInt("id");
                       String title= rs.getString("title");
                          System.out.println("id:"+id+"title:"+title);
                  }
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }finally {
                        //            5.释放资源
                        try {
                                connection.close();
                                stmt.close();
                                rs.close();
                        } catch (SQLException throwables) {
                                throwables.printStackTrace();
                        }
                }


        }
}
