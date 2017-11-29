package com.ssm.blog.dao;

import com.ssm.blog.pojo.BlogDiary;

import java.util.List;

/**
 * @Houxudong
 **/
public interface BlogDiaryDao {
    void addBlogDiary(BlogDiary diary);
    List<BlogDiary> getDiaryList(Integer userId);
}
