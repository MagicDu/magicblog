package cn.magicdu.blog.web;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.pojo.User;
import cn.magicdu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;
    private Msg msg;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public @ResponseBody User getUser(){
        User user=new User();
        user.setUsername("magicdu");
        user.setPassword("hello");
        return  user;
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public @ResponseBody Msg login(){
            msg=Msg.getInstance();
            msg.setKey(SystemParam.OK);
            msg.setValue("");
            return msg;
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public @ResponseBody Msg register(User user){
        msg=Msg.getInstance();
        service.addUser(user,msg);
        return msg;
    }
}
