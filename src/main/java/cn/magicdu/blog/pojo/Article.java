package cn.magicdu.blog.pojo;

import javax.validation.constraints.NotBlank;

/**
 *  Article Info
 * @author magicdu
 * @Date 2018/06/24
 * @version 1.0.0
 */
public class Article {
    private  String articleid;
    @NotBlank
    private  String articletitle;
    @NotBlank
    private  String articlecontent;
    private  String createdate;
    private  String postdate;
    private  int poststatus;
    private  String postpassword;
    private  int commentstaus;
    private  String userid;
    private  String categoryid;


    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public int getPoststatus() {
        return poststatus;
    }

    public void setPoststatus(int poststatus) {
        this.poststatus = poststatus;
    }

    public String getPostpassword() {
        return postpassword;
    }

    public void setPostpassword(String postpassword) {
        this.postpassword = postpassword;
    }

    public int getCommentstaus() {
        return commentstaus;
    }

    public void setCommentstaus(int commentstaus) {
        this.commentstaus = commentstaus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }
}
