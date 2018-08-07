package cn.magicdu.blog.pojo;

/**
 * category info
 * @author magidu
 * @version 1.0.0
 * @Date 2018/08/07
 */
public class Category {
    private int categoryid;
    private String categoryname;
    private String userid;
    private int parentcateid;

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getParentcateid() {
        return parentcateid;
    }

    public void setParentcateid(int parentcateid) {
        this.parentcateid = parentcateid;
    }
}
