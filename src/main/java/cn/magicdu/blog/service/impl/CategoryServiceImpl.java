package cn.magicdu.blog.service.impl;

import cn.magicdu.blog.dao.CategoryMapper;
import cn.magicdu.blog.pojo.Category;
import cn.magicdu.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public List<Category> getUserCategory(String userid) {
        return categoryMapper.getUserCategory(userid);
    }
}
