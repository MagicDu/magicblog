package cn.magicdu.blog.service.impl;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.dao.MenuMapper;
import cn.magicdu.blog.pojo.Menu;
import cn.magicdu.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public void getMenuList(Msg msg) {
        msg.setKey(SystemParam.OK);
        // 将menuList  转化为菜单树返回
        msg.setValue(turnMenuListToTree(menuMapper.getMenuList()));
    }


    /**
     * 将菜单转化为树
     * @param menuList
     * @return
     */
    private Map  turnMenuListToTree(List<Menu> menuList){
        if(menuList==null||menuList.size()==0){
            return null;
        }
        // 首先找到一级菜单，一级菜单 parent_id  为空
        List<Menu> parentMenus=new ArrayList<>();
        for(int i=0;i<menuList.size();i++){
            if(StringUtils.isEmpty(menuList.get(i).getParent_menu_id())){
                parentMenus.add(menuList.get(i));
            }
        }
        for(Menu menu:parentMenus){
          menu.setChildMenuList(getChildMenus(menu.getMenu_id(),menuList));
        }
        Map map=new HashMap<String,Object>();
        map.put("menu",parentMenus);
        return map;
    }

    /**
     * 递归获取子菜单
     * @param p_id
     * @param menuList
     * @return
     */
    private List<Menu> getChildMenus(String p_id,List<Menu> menuList){
        List<Menu> childMenus=new ArrayList<>();
        for (Menu menu:menuList){
            if(!StringUtils.isEmpty(p_id)){
                if(menu.getParent_menu_id().equals(p_id)){
                    childMenus.add(menu);
                }
            }
        }
        // 递归查找子菜单的子菜单
        for(Menu cmenu:childMenus){
            cmenu.setChildMenuList(getChildMenus(cmenu.getMenu_id(),menuList));
        }
      return childMenus;
    }
}
