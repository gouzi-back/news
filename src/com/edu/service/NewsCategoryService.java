package com.edu.service;

import com.edu.pojo.NewsCategory;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 21:26
 * @Description:com.edu.service
 * @Version: 1.0
 */
//对新闻类别惊醒业务逻辑的操作
public interface NewsCategoryService {
    //删除新闻分类
    public boolean deleteNewsCategory(NewsCategory newsCategory);
}
