package cn.magicdu.blog.service.impl;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.dao.UserMapper;
import cn.magicdu.blog.pojo.User;
import cn.magicdu.blog.pojo.UserValidateInfo;
import cn.magicdu.blog.service.UserService;
import cn.magicdu.blog.util.JwtTokenUtil;
import cn.magicdu.blog.util.MagicUtil;
import cn.magicdu.blog.util.PasswordHash;
import cn.magicdu.core.DateUtil;
import cn.magicdu.core.date.DatePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public void addUser(User user,Msg msg) {
        // 首先需要判断是否存在该用户名
        if (getUserByName(user.getUsername())>0){
            msg.setKey(SystemParam.ERROR);
            msg.setValue("user has already existed");
        }else{
            try {
                String hash= PasswordHash.createHash(user.getPassword());
                String [] strArray=hash.split(":");
                hash=MagicUtil.Base64(hash,"encode");
                user.setPassword(hash);
                user.setHashsalt(strArray[1]);
                user.setUserid(MagicUtil.createUUID());
                user.setRoleid("test");
                user.setRegisterdate(DateUtil.now(DatePattern.NORM_DATETIME_PATTERN));
                user.setUpdatedate(DateUtil.now(DatePattern.NORM_DATETIME_PATTERN));
                mapper.addUser(user);
                msg.setKey(SystemParam.OK);
                msg.setValue("user added success");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public int getUserByName(String username) {
        System.err.println("get user");
        return mapper.getUserByName(username);
    }

    @Override
    public void validateUser(String username, String password,Msg msg) {
        UserValidateInfo uvinfo=mapper.validateUser(username);
        if(uvinfo!=null){
            try {
               boolean flag= PasswordHash.validatePassword(password,MagicUtil.Base64(uvinfo.getPassword()));
               if(flag){
                   msg.setKey(SystemParam.OK);
                   msg.setValue(jwtTokenUtil.generateToken(uvinfo));
               }else{
                   msg.setKey(SystemParam.ERROR);
                   msg.setValue("username or password is not correct");
               }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }else{
            msg.setKey(SystemParam.ERROR);
            msg.setValue("username or password is not correct");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user=mapper.validateUser(username);
        if(user==null){
            throw new UsernameNotFoundException(" username:"+username+"not found");
        }
        return user;
    }
}
