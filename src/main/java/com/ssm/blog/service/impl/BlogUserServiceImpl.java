package com.ssm.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.dao.BlogUserDao;
import com.ssm.blog.pojo.BlogDiary;
import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogDiaryService;
import com.ssm.blog.service.BlogUserService;
import com.ssm.blog.util.Constants;
import com.ssm.blog.util.Funcs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Houxudong
 **/
@Service
public class BlogUserServiceImpl implements BlogUserService{
    @Autowired
    private BlogUserDao blogUserDao;

    @Override
    public void doRegist(BlogUser user) {
        //MD5加密
        String password = user.getPassWord()+ Constants.PASSWORD_SALT_KEY;
        user.setPassWord(Funcs.MD5(password));
        blogUserDao.addUser(user);
    }

    @Override
    public BlogUser doLogin(String userName, String password) throws Exception {
        BlogUser user = blogUserDao.getUserByUserName(userName);
        if(user!=null && Funcs.MD5(password+Constants.PASSWORD_SALT_KEY).equals(user.getPassWord())){
            return user;
        }
        throw new Exception("用户名或密码错误");
    }

    @Override
    public BlogUser getUserByUserName(String userName) {
        return blogUserDao.getUserByUserName(userName);
    }

    @Override
    public BlogUser getUserById(Integer id) {
        return blogUserDao.getUserById(id);
    }

    @Override
    public void updateUser(BlogUser user) {
        blogUserDao.updateUser(user);
    }
}
