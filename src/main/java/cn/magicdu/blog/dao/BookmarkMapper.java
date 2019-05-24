package cn.magicdu.blog.dao;

import cn.magicdu.blog.pojo.Bookmark;

import java.util.List;


public interface BookmarkMapper {
     void addBookmark(Bookmark bookmark);
     List<Bookmark> getBookmarksByUserid(String user_id);
}

