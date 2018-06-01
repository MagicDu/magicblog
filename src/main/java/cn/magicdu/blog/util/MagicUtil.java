package cn.magicdu.blog.util;


import cn.magicdu.blog.Msg;
import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.pojo.User;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

/**
 *  util of the system
 * @author magicdu
 * @Date 2018/05/12
 * @version 1.0.0
 */
public class MagicUtil {
    private MagicUtil(){}

    /**
     * generate  salt
     * @return salt
     */
    public static String generateSalt(){
        SecureRandom random=new SecureRandom();
        byte[] salt=new byte[15];
        random.nextBytes(salt);
        return new BASE64Encoder().encode(salt);
    }
    /**
     * hash password and salt
     */
    public static String encryptInfo(String infoStr,String salt){
        return null;
    }

    /**
     * validate info
     * @param object
     * @return
     */
    public static boolean validateInfo(Object object,Msg msg){
        if(object instanceof User){
            validateUserInfo((User) object,msg);
        }
        return false;
    }

    /**
     * validate user info
     * @param user
     * @return
     */
    public static boolean validateUserInfo(User user,Msg msg){
        if(strIsBlank(user.getUsername())){
            msg.setKey(SystemParam.ERROR);
            msg.setValue("username can't be null");
        }
        return false;
    }



    public static boolean validateObjectInfo(Object object,Msg msg){

        if(object==null){
            return false;
        }
        Field[] fields= object.getClass().getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            Object result;
            String type;
            try {
                result=field.get(object);
                type=field.getType()+"";
                if(type.startsWith("class")){
                    type=type.split(" ")[1].toString().split("\\.")[2];
                }
                if(SystemParam.String.equals(type)){
                    if(strIsBlank((String)result)){
                        return false;
                    }
                }
                //System.out.println(type+":"+result);
            } catch (IllegalAccessException e) {
                msg.setKey(SystemParam.EXCEPTION);
                msg.setValue("IllegalAccessException");
                e.printStackTrace();
            }
        }
        return false;
    }



    /**
     * validate str is null or "" or "   "
     * @param str
     * @return
     */
    public static boolean strIsBlank(String str){
        if(str==null||"".equals(str)||str.trim().equals("")){
            return true;
        }else{
            return false;
        }

    }

    /**
     * generate uuid
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }


    /**
     * Base64 encode and decode
     * @param text
     * @param params
     * @return
     */
    public static String Base64(String text,String ...params){

            try {
                if(params.length>0&&params[0].equals("encode")) {
                    return Base64.getEncoder().encodeToString(text.getBytes("UTF-8"));
                }else{
                    return new String(Base64.getDecoder().decode(text),"UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
        }
        return  null;
    }

    /**
     * Common return view
     * @param viewvalue
     * @return
     */
    public static ModelAndView commonView(String viewvalue){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg",viewvalue);
        mv.setViewName("common");
        return  mv;
    }
    public static void main(String[] args) {
        User user=new User();
        Msg msg=Msg.getInstance();
        user.setUsername("hello");
        user.setPassword("magic");
        validateObjectInfo(user,msg);
    }

}
