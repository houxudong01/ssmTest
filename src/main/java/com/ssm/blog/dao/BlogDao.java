package com.ssm.blog.dao;

import com.ssm.blog.pojo.Blog;

import java.util.List;

/**
 * @Houxudong
 **/
public interface BlogDao {
    void addBlog(Blog blog);
    List<Blog> getBlogList();
}
