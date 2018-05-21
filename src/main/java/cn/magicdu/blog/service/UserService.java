package cn.magicdu.blog.service;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.User;
import cn.magicdu.blog.pojo.UserValidateInfo;


public interface UserService {
     void addUser(User user,Msg msg);
     void validateUser(String username,String password,Msg  msg);
     int getUserByName(String username);
}
