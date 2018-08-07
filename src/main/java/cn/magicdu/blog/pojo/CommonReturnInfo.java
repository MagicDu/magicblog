package cn.magicdu.blog.pojo;

/**
 * the common info return to web
 *
 * @author magicdu
 * @version 1.0.0
 * @date 2018/08/07
 */
public class CommonReturnInfo {
    /** which view the common.html init */
    private String viewname;
    /** json data that html to parse*/
    private String jsonData;

    public String getViewname() {
        return viewname;
    }

    public void setViewname(String viewname) {
        this.viewname = viewname;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
