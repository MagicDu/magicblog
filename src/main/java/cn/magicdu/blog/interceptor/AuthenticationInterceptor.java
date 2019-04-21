package cn.magicdu.blog.interceptor;

import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.annotation.Notoken;
import cn.magicdu.blog.annotation.UseToken;
import cn.magicdu.blog.service.UserService;
import cn.magicdu.blog.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token=request.getHeader(SystemParam.HEADER_STRING);
        if(handler instanceof HandlerMethod){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        if(method.isAnnotationPresent(Notoken.class)){
            Notoken notoken=method.getAnnotation(Notoken.class);
            if(notoken.required()){
                return true;
            }
        }
        if(method.isAnnotationPresent(UseToken.class)){
            UseToken useToken=method.getAnnotation(UseToken.class);
            if(useToken.required()){
                if(token==null){
                    return false;
                }
                String username=jwtTokenUtil.getUsernameFromToken(token);
                if(username!=null){
                   UserDetails userDetails= userService.loadUserByUsername(username);
                   return jwtTokenUtil.validateToken(token,userDetails);
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
