package cn.magicdu.blog.service;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.Bookmark;

public interface BookmarkService {
    void addBookmark(Bookmark bookmark,Msg msg);
    void getUserBookmarks(String user_id,Msg msg);


}
