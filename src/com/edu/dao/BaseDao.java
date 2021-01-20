package com.edu.dao;

import java.sql.*;

/**
 * @Auther:haha
 * @Date:2021/1/20 - 01 - 20 22:38
 * @Description:com.edu.dao
 * @Version: 1.0
 */

/*数据库操作类    DAO模式及单例模式-编写DAO操作的基类*/
public class BaseDao {

    ResultSet resultSet=null;
    Connection connection =null;
    PreparedStatement preparedStatement=null;


    //获取数据库连接
    public boolean getConnection() {

        try {
            // class.forName(String) 加载不同数据库厂商提供的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //1.获取链接 connection
            String url = "jdbc:mysql://localhost:3306/kgcnews?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
            connection = DriverManager.getConnection(url, "root", "1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    //  增删改 返回int
    public int addDelUpdate(String sql,Object[] params){
        //返回几条成功的语句 int 类型
        int updateRows=0;
        //if判断是否获得连接  this.getConnection()
        if (this.getConnection()){
            try {
                preparedStatement=connection.prepareStatement(sql);
                //填充占位符
                for (int i = 0; i <params.length ; i++) {
                    preparedStatement.setObject(i+1,params[i]);

                }
                //返回受影响的行数
                updateRows=  preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return updateRows ;
    }
    //  查 返回一个结果集ResultSet
    public ResultSet selectSql(String sql,Object[] params){
        //if判断是否获得连接  this.getConnection()
        if (this.getConnection()){
            try {
                preparedStatement=connection.prepareStatement(sql);
                //填充占位符
                for (int i = 0; i <params.length ; i++) {
                    preparedStatement.setObject(i+1,params[i]);

                }
             //执行返回的结果给resultSet
                resultSet=preparedStatement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return resultSet;
    }
    // 释放资源
    public boolean closeResource(){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
