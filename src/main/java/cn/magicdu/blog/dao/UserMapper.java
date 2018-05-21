package cn.magicdu.blog.dao;

import cn.magicdu.blog.pojo.User;
import cn.magicdu.blog.pojo.UserValidateInfo;


public interface UserMapper {
     void addUser(User user);
     UserValidateInfo validateUser(String username);
     int getUserByName(String username);
}

