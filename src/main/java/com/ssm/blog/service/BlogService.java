package com.ssm.blog.service;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.pojo.Blog;

/**
 * @Houxudong
 **/
public interface BlogService {
    void addBlog(Blog blog);
    PageInfo<Blog> getBlogList(Integer pageNo);
}
