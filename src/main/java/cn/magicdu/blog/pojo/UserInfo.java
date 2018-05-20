package cn.magicdu.blog.pojo;


/**
 * Simple user information(return UI)
 *  @author magicdu
 *  @Date 2018/05/10
 *  @version 1.0.0
 */
public class UserInfo {
    private String userid;
    private String username;
    private String nickname;
    private String avatar;
    private String useremail;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
