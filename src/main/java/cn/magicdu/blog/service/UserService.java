package cn.magicdu.blog.service;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.User;



public interface UserService {
     void addUser(User user,Msg msg);
     int getUserByName(String username);
}
