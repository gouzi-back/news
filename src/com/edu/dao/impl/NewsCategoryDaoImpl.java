package com.edu.dao.impl;

import com.edu.dao.BaseDao;
import com.edu.dao.NewsCategoryDao;
import com.edu.pojo.NewsCategory;

/**
 * @Auther:haha
 * @Date:2021/1/21 - 01 - 21 20:57
 * @Description:com.edu.dao.impl
 * @Version: 1.0
 */
public class NewsCategoryDaoImpl extends BaseDao implements NewsCategoryDao {

    @Override
    public boolean deleteCategorry(NewsCategory newsCategory) {
        boolean flag=false;
        String sql="delete from news_category where id=?";
        Object[] params={newsCategory.getId()};
        int i = this.addDelUpdate(sql, params);
        if (i>0){
            System.out.println("删除新闻类别成功");
            flag=true;
        }
      return flag;
    }
}
