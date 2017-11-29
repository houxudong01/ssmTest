package com.ssm.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.pojo.BlogDiary;
import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogDiaryService;
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
@RequestMapping("/diary")
public class BlogDiaryController {
    @Autowired
    private BlogDiaryService blogDiaryService;
    @RequestMapping("/add.html")
    public String add(BlogDiary diary, HttpSession session){
        BlogUser user = (BlogUser) session.getAttribute(Constants.SESSION_USER);
        diary.setUserId(user.getId());
        blogDiaryService.addBlogDiary(diary);
        return "redirect:/diary/list.html";
    }
    @RequestMapping("/list.html")
    public ModelAndView list(@RequestParam(required = false,defaultValue = "1") Integer pageNo,HttpSession session){
        BlogUser user = (BlogUser) session.getAttribute(Constants.SESSION_USER);
        PageInfo<BlogDiary> page = blogDiaryService.getDiaryList(user.getId(),pageNo);
        return new ModelAndView("/diary/list","page",page);
    }
}
