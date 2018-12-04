package com.zhengguan.SSMjm.controllers;


import com.zhengguan.SSMjm.commutil.R;
import com.zhengguan.SSMjm.entities.NoteResult;
import com.zhengguan.SSMjm.entities.User;
import com.zhengguan.SSMjm.servlet.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import java.util.Date;
import java.util.List;

import static java.lang.System.out;

@Controller
@RequestMapping()
public class LoginController {


    @Autowired
    UserService userService;


//    @RequestMapping("/regist")
//    @ResponseBody
//    public NoteResult execute(String username, String password , String phone,String email) throws NoSuchAlgorithmException {
//        NoteResult result= userService.regist(username, password, phone,email);
//        return  result;
//    }


//    @RequestMapping("/login")
//    @ResponseBody
//    public NoteResult execute(String username,String password) throws NoSuchAlgorithmException {
//        NoteResult result = userService.checkLogin(username,password);
//        return result;
//    }



    @RequestMapping("zc")
    public String toAddUser(Model model){
//        model.addAttribute("protype",protypeService.querygetAllProtype());

        return "zhuce";
    }

    @RequestMapping("dl")
    public String dl(Model model,HttpSession session,String username){
//        model.addAttribute("protype",protypeService.querygetAllProtype());
        session.setAttribute("username", username);
        return "login";
    }

    @RequestMapping("main")
    public String main(Model model){
//        model.addAttribute("protype",protypeService.querygetAllProtype());
        model.addAttribute("user",userService.queryUser());
        return "index";
    }




    @RequestMapping("/addUsers")
    public String addUsers(Model model,String username, String password , String phone,String email){

        try {
            userService.regist(username, password, phone,email);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "login";
    }

    //文件导出
    @RequestMapping("/files")
    @ResponseBody
    public void act28(HttpServletResponse response) throws IOException {
        //POI
        //response.setContentType("text/html;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        //问题：下载xls问题用excel打开乱码，用notepad++等工具转成UTF-8格式(带BOM)可以正常打开。
        //解决：严格来说这并不是xls文件的问题，而是Excel处理文件编码方式问题，Excel默认并不是以UTF-8来打开文件，所以在xls开头加入BOM，告诉Excel文件使用utf-8的编码方式。
        response.setHeader("Content-Type","application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=goods.xls");
        PrintWriter out = response.getWriter();
        //加上bom头,解决excel打开乱码问题
        byte[] bomStrByteArr = new byte[] { (byte) 0xef, (byte) 0xbb, (byte) 0xbf };
        String bomStr = new String(bomStrByteArr, "UTF-8");
        out.write(bomStr);
        StringBuffer str=new StringBuffer("");
        str.append("<table border=1 width=100%>");
        str.append("<tr><th>编号</th><th>用户名</th><th>电话</th><th>邮箱</th><th>注册时间</th></tr>");
        List<User> list=userService.queryUser();
        for (User user:list ) {
            str.append("<tr><td>"+user.getId()+"</td><td>"+user.getUsername()+"</td><td>"+user.getPhone()+"</td><td>"+user.getEmail()+"</td><td>"+user.getUdate()+"</td></tr>");
        }
        str.append("</table>");
        out.write(str.toString());
    }
    @RequestMapping("/del")
    public  String del(Model model,String name, @RequestParam("id") List<Integer> ids){
        String msg="操作成功!";
        if(userService.deleteByIds(ids)<=0){
            msg="操作失败!";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("user",userService.queryUser());
        return "forward:main";
    }


    @RequestMapping("/login")
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session){
        User user=userService.login(username, password);
        if(user!=null){
            //登录成功，将user对象设置到HttpSession作用范围域中
            session.setAttribute("user", user);
            //转发到main请求
            mv.setView(new RedirectView("index"));
        }else {
            //登录失败，设置失败信息，并调转到登录页面
            mv.addObject("message","登录名和密码错误，请重新输入");
            mv.setViewName("main");
        }
        return mv;
    }

    @RequestMapping("/upd")
    @ResponseBody
    public R upd(HttpServletRequest request) {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUsername(request.getParameter("username"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        return R.ok(userService.updUser(user));
     }


    //跨域
    @RequestMapping("/fzjson")
    @ResponseBody
    public void fzjson(HttpServletResponse response)throws ServletException, IOException{
//        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020");
//        response.addHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, TRACE, OPTIONS,PUT,DELETE");
//        response.addHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
//        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write("{\"name\":\"Book\",\"sex\":\"男\"}");
    }


    }
