package com.ssm.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.pojo.Blog;
import com.ssm.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Houxudong
 **/
@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/add.html")
    public String add(Blog blog){
        blogService.addBlog(blog);
        return "redirect:/blog/index.html";
    }
    @RequestMapping("/index.html")
    public ModelAndView list(@RequestParam(required = false,defaultValue = "1") Integer pageNo){
        PageInfo<Blog> pageInfo = blogService.getBlogList(pageNo);
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("页码：" + pageInfo.getPageNum());
        System.out.println("总条数："+pageInfo.getTotal());
        return new ModelAndView("index","page",pageInfo);
    }
}
