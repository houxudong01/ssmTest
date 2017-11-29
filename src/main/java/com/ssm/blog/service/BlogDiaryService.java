package com.ssm.blog.service;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.pojo.BlogDiary;

/**
 * @Houxudong
 **/
public interface BlogDiaryService {
    void addBlogDiary(BlogDiary diary);
    PageInfo<BlogDiary> getDiaryList(Integer userId,Integer pageNo);
}
