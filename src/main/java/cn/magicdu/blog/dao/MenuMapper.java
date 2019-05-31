package cn.magicdu.blog.dao;

import cn.magicdu.blog.pojo.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
@CacheConfig(cacheNames = "menus")
public interface MenuMapper {
    @Cacheable(key="'menu_id'")
    List<Menu> getMenuList();
}
