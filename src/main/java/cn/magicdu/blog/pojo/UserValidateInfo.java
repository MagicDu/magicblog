package cn.magicdu.blog.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author magicdu
 * @Date 2018-05-21
 * @version 1.0.0
 * validate user info bean
 */
public class UserValidateInfo implements UserDetails {
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

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
