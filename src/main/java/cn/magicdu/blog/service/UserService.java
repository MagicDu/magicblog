package cn.magicdu.blog.service;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.User;
import cn.magicdu.blog.pojo.UserValidateInfo;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
     void addUser(User user,Msg msg);
     void validateUser(String username,String password,Msg  msg);
     int getUserByName(String username);
}
