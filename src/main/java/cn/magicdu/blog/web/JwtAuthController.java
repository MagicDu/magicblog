package cn.magicdu.blog.web;

import cn.magicdu.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthController {
    @Autowired
    private AuthService authService;
    @RequestMapping(value = "/authentication/login",method = RequestMethod.POST)
    public String createToken(String username,String password){
        return authService.login(username,password);
    }
}
