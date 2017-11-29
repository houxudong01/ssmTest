package com.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.blog.dao.BlogDao;
import com.ssm.blog.pojo.Blog;
import com.ssm.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Houxudong
 **/
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogDao blogDao;
    @Override
    public void addBlog(Blog blog) {
        blogDao.addBlog(blog);
    }

    @Override
    public PageInfo<Blog> getBlogList(Integer pageNo) {
        PageHelper.startPage(pageNo,2,"id desc");
        List<Blog> blogList = blogDao.getBlogList();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }
}
