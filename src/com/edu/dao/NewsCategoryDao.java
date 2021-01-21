package com.edu.dao;

import com.edu.pojo.NewsCategory;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 20:52
 * @Description:com.edu.dao
 * @Version: 1.0
 */
public interface NewsCategoryDao {
    //删除某个新闻类别
    public boolean deleteCategorry(NewsCategory newsCategory);
}
