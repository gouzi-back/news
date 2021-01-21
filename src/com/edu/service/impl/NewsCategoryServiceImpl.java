package com.edu.service.impl;

import com.edu.dao.NewsCategoryDao;
import com.edu.dao.PreparedStatementDemo;
import com.edu.dao.impl.NewsCategoryDaoImpl;
import com.edu.dao.impl.PreparedStatementDemoImpl;
import com.edu.pojo.NewsCategory;
import com.edu.service.NewsCategoryService;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 21:27
 * @Description:com.edu.service.impl
 * @Version: 1.0
 */
public class NewsCategoryServiceImpl implements NewsCategoryService {
    private PreparedStatementDemo newsDao;
    private NewsCategoryDao newsCategoryDao;

    public NewsCategoryServiceImpl() {
        newsDao = new PreparedStatementDemoImpl();
        newsCategoryDao = new NewsCategoryDaoImpl();
    }

    @Override
    public boolean deleteNewsCategory(NewsCategory newsCategory) {
        boolean flag=false;
        int count = newsDao.getCountByCategory(newsCategory);
        if (count>0) {
            System.out.println("无法删除该分类 该分类下还有丁文呢！！");
        } else {
           flag=newsCategoryDao.deleteCategorry(newsCategory);
        }

        return flag;
    }
}
