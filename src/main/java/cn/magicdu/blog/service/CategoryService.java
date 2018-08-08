package cn.magicdu.blog.service;

import cn.magicdu.blog.pojo.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    List<Category> getUserCategory(String userid);

}
