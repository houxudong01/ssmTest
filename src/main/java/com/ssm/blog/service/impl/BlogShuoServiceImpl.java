package com.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.blog.dao.BlogShuoDao;
import com.ssm.blog.pojo.BlogShuo;
import com.ssm.blog.service.BlogShuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Houxudong
 **/
@Service
public class BlogShuoServiceImpl implements BlogShuoService{
    @Autowired
    private BlogShuoDao blogShuoDao;
    @Override
    public void addBlogShuo(BlogShuo shuo) {
        blogShuoDao.addBlogShuo(shuo);
    }

    @Override
    public PageInfo<BlogShuo> getShuoList(Integer userId,Integer pageNo) {
        PageHelper.startPage(pageNo,4,"id desc");
        List<BlogShuo> shuoList =  blogShuoDao.getShuoList(userId);
        PageInfo<BlogShuo> page = new PageInfo<>(shuoList);
        page.setNavigateFirstPage(page.getPageNum()-2<1?1:page.getPageNum()-2);
        page.setNavigateLastPage(page.getPageNum()+2>page.getPages()?page.getPages():page.getPageNum()+2);
        return page;
    }
}
