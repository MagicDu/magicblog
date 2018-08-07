package cn.magicdu.blog.dao;

import cn.magicdu.blog.pojo.Category;

import java.util.List;

public interface CategoryMapper {
   void addCategory();
    List<Category> getUserCategory(String userid);
}
