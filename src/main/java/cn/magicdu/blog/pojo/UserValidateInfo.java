package cn.magicdu.blog.pojo;

/**
 * @author magicdu
 * @Date 2018-05-21
 * @version 1.0.0
 * validate user info bean
 */
public class UserValidateInfo {
    private String userid;
    private  String username;
    private String password;
    private String hashsalt;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashsalt() {
        return hashsalt;
    }

    public void setHashsalt(String hashsalt) {
        this.hashsalt = hashsalt;
    }
}
