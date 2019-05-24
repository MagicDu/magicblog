package cn.magicdu.blog.service.impl;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.dao.BookmarkMapper;
import cn.magicdu.blog.pojo.Bookmark;
import cn.magicdu.blog.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    @Autowired
    private BookmarkMapper bookmarkMapper;
    @Override
    public void addBookmark(Bookmark bookmark, Msg msg) {
        bookmarkMapper.addBookmark(bookmark);
        msg.setKey(SystemParam.OK);
        msg.setValue("ok");
    }

    @Override
    public void getUserBookmarks(String user_id, Msg msg) {
        msg.setKey(SystemParam.OK);
        msg.setValue(bookmarkMapper.getBookmarksByUserid(user_id));
    }
}
