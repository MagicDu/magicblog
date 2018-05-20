package cn.magicdu.blog.dao;

import cn.magicdu.blog.pojo.User;




public interface UserMapper {
     void addUser(User user);

     int getUserByName(String username);
}

