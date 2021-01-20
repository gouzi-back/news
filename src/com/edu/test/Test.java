package com.edu.test;

import com.edu.dao.PreparedStatementDemo;
import com.edu.dao.impl.PreparedStatementDemoImpl;

import java.util.Date;

/**
 * @Auther:haha
 * @Date:2021/1/20 - 01 - 20 23:47
 * @Description:com.edu.test
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        PreparedStatementDemo pd = new PreparedStatementDemoImpl();
//        //查询全部
        pd.getAllNewsByTitle();
        System.out.println("======================================================================================");
//        //指定查询
//        pd.getNewsByTitle("Java" + "%");
//        //新增
//        pd.addNews(5, 2, "hhhhhh", "dddddd", "dddddd", "dddddd", new Date());
//        System.out.println("======================================================================================");
//        //修改
//        pd.updateNews(3,"我笑了呀 手术室护士水水水水");
//        System.out.println("======================================================================================");
        //删除
        pd.deleteNews(5);


    }
}
