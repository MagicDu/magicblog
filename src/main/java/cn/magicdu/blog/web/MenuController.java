package cn.magicdu.blog.web;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private Msg msg;
    @Autowired
    private MenuService menuService;
    @RequestMapping(value = "/getMenus",method = RequestMethod.POST)
    public Msg getMenuList(){
        msg=Msg.getInstance();
        menuService.getMenuList(msg);
        return msg;
    }

}
