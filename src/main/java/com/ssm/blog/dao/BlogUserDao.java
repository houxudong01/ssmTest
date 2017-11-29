package com.ssm.blog.dao;

import com.ssm.blog.pojo.BlogUser;

public interface BlogUserDao {
    void addUser(BlogUser user);
    BlogUser getUserByUserName(String userName);
    BlogUser getUserById(Integer id);
    void updateUser(BlogUser user);
}
