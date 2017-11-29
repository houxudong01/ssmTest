package com.ssm.blog.controller;

import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogUserService;
import com.ssm.blog.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Houxudong
 **/
@Controller
@RequestMapping("/user")
public class BlogUserController {
    @Autowired
    private BlogUserService blogUserService;
    @RequestMapping("/regist.html")
    public String regist(@Validated BlogUser user, BindingResult result, HttpServletRequest request,HttpSession session){
        request.setAttribute("error",result);
        if(!result.hasErrors()){

            blogUserService.doRegist(user);
            session.setAttribute(Constants.SESSION_USER,user);
            return "redirect:/blog/index.html";
        }
        return "regist";

    }
    @RequestMapping("/login.html")
    public String login(String userName, String passWord, HttpSession session){

        try {
            BlogUser user = blogUserService.doLogin(userName,passWord);
            session.setAttribute(Constants.SESSION_USER,user);
            return "redirect:/blog/index.html";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/loginout.html")
    public String loginout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/check.html")
    @ResponseBody
    public Map<String,Object> check(String userName){
        BlogUser user = blogUserService.getUserByUserName(userName);
        Map<String,Object> result = new HashMap<>();
        if(user!=null){
            result.put("status",false);
            result.put("msg","用户名已存在");
        }else{
            result.put("status",true);
            result.put("msg","用户名可以使用");
        }
        return result;
    }
    @RequestMapping("/go_update.html")
    public String goUpdate(Model model,HttpSession session) throws Exception{
        BlogUser user1 = (BlogUser) session.getAttribute(Constants.SESSION_USER);
        BlogUser user = blogUserService.getUserById(user1.getId());
        if(user==null){
            throw new Exception("用户不存在");
        }
        model.addAttribute("user",user);
        return "user_update";
    }
    @RequestMapping("/update.html")
    public String update(@Validated BlogUser blogUser,BindingResult result,HttpServletRequest request,HttpSession session){
        request.setAttribute("error",result);
        if(!result.hasErrors()){
            blogUserService.updateUser(blogUser);
            session.setAttribute(Constants.SESSION_USER,blogUser);
            return "user_info";
        }
        return "user_update";
    }
}
