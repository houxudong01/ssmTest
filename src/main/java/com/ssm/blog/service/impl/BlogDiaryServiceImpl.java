package com.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.blog.dao.BlogDiaryDao;
import com.ssm.blog.pojo.BlogDiary;
import com.ssm.blog.service.BlogDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Houxudong
 **/
@Service
public class BlogDiaryServiceImpl implements BlogDiaryService{
    @Autowired
    private BlogDiaryDao blogDiaryDao;

    @Override
    public void addBlogDiary(BlogDiary diary) {
        blogDiaryDao.addBlogDiary(diary);
    }

    @Override
    public PageInfo<BlogDiary> getDiaryList(Integer userId,Integer pageNo) {
        PageHelper.startPage(pageNo,4,"id desc");
        List<BlogDiary> diaryList = blogDiaryDao.getDiaryList(userId);
        PageInfo<BlogDiary> page = new PageInfo<>(diaryList);
        return page;
    }
}
