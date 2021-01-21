package com.edu.test;

import com.edu.pojo.NewsCategory;
import com.edu.service.NewsCategoryService;
import com.edu.service.impl.NewsCategoryServiceImpl;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 21:44
 * @Description:com.edu.test
 * @Version: 1.0
 */
public class TestTwo {
    public static void main(String[] args) {
        //测试新闻分类删除
        NewsCategory newsCategory =new NewsCategory();
        newsCategory.setId(7);

        NewsCategoryService newsCategoryService =new NewsCategoryServiceImpl();
        newsCategoryService.deleteNewsCategory(newsCategory);
    }
}
