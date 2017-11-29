package com.ssm.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.pojo.BlogShuo;
import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogShuoService;
import com.ssm.blog.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Houxudong
 **/
@Controller
@RequestMapping("/shuo")
public class BlogShuoController {
    @Autowired
    private BlogShuoService blogShuoService;
    @RequestMapping("/add.html")
    public String add(BlogShuo shuo, HttpSession session){
        BlogUser user = (BlogUser) session.getAttribute(Constants.SESSION_USER);
        shuo.setUserId(user.getId());
        blogShuoService.addBlogShuo(shuo);
        return "redirect:/shuo/list.html";
    }
    @RequestMapping("/list.html")
    public ModelAndView list(@RequestParam(required = false,defaultValue = "1") Integer pageNo,HttpSession session){
        BlogUser user = (BlogUser) session.getAttribute(Constants.SESSION_USER);
        PageInfo<BlogShuo> page = blogShuoService.getShuoList(user.getId(),pageNo);
        return new ModelAndView("/shuo/list","page",page);
    }
}
