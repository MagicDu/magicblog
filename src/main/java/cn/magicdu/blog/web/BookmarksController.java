package cn.magicdu.blog.web;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.Bookmark;
import cn.magicdu.blog.service.BookmarkService;
import cn.magicdu.blog.util.MagicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
public class BookmarksController {
    private Msg msg;
    @Autowired
    private BookmarkService bookmarkService;
    @RequestMapping(value = "/addBookmark",method = RequestMethod.POST)
    public Msg addBookmarks(Bookmark bookmark){
        bookmark.setCategory_id("test");
        bookmark.setDescription("hello");
        bookmark.setId(MagicUtil.createUUID());
        bookmark.setUser_id("test");
        bookmark.setUrl("www.v2ex.com");
        bookmark.setState(1);
        bookmark.setName("测试");
        msg=Msg.getInstance();
        bookmarkService.addBookmark(bookmark,msg);
        return msg;
    }
    @RequestMapping(value = "/selectBookmarks",method = RequestMethod.POST)
    public Msg selectBookmarks(String user_id){
        msg=Msg.getInstance();
        bookmarkService.getUserBookmarks(user_id,msg);
        return  msg;
    }
}
