package cn.magicdu.blog.pojo;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private String menu_id;
    private String child_menu_id;
    private String parent_menu_id;
    private String menu_name;
    private String menu_url;
    private String menu_description;
    private int is_menu_show;
    private List<Menu> childMenuList;

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getChild_menu_id() {
        return child_menu_id;
    }

    public void setChild_menu_id(String child_menu_id) {
        this.child_menu_id = child_menu_id;
    }

    public String getParent_menu_id() {
        return parent_menu_id;
    }

    public void setParent_menu_id(String parent_menu_id) {
        this.parent_menu_id = parent_menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_description() {
        return menu_description;
    }

    public void setMenu_description(String menu_description) {
        this.menu_description = menu_description;
    }

    public int getIs_menu_show() {
        return is_menu_show;
    }

    public void setIs_menu_show(int is_menu_show) {
        this.is_menu_show = is_menu_show;
    }

    public List<Menu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<Menu> childMenuList) {
        this.childMenuList = childMenuList;
    }
}
