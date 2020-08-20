package com.wf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wf.domain.User;
import com.wf.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.web.servlet.view.UrlBasedViewResolver.FORWARD_URL_PREFIX;
import static org.springframework.web.servlet.view.UrlBasedViewResolver.REDIRECT_URL_PREFIX;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/save23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile uploadFile : uploadFiles) {
            System.out.println(username);
            System.out.println(uploadFile);
            // 获得上传文件的名称
            String originalFilename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("/Users/wangfei/Desktop/MyJava/upload/" + originalFilename));
        }


    }

    @RequestMapping(value="/save22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        // 获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("/Users/wangfei/Desktop/MyJava/upload/" + originalFilename));

    }

    @RequestMapping(value="/save21")
    @ResponseBody
    public void save21(@CookieValue("JSESSIONID") String SESSIONID) throws IOException {
        System.out.println(SESSIONID);

    }

    @RequestMapping(value="/save20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_agent) throws IOException {
        System.out.println(user_agent);

    }

    @RequestMapping(value="/save19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/save18")
    @ResponseBody
    public void save18(Date data) {

        System.out.println(data);
    }

    @RequestMapping("/save17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) {

        System.out.println(username);
    }

    @RequestMapping("/save16")
    @ResponseBody
    public void save16(@RequestParam("name") String username) {

        System.out.println(username);
    }

//    ajax提交的body里的集合用这种
    @RequestMapping("/save15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {

        System.out.println(userList);
    }

//    集合，form表单提交集合用这种
    @RequestMapping("/save14")
    @ResponseBody
    public void save13(VO vo) {

        System.out.println(vo);
    }

    // http://localhost:8080/user/save?a=111,b=222,c=333
    @RequestMapping(value="/save13")
    @ResponseBody
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/save12")
    @ResponseBody
    public void save12(User user) {

        System.out.println(user);
    }

    @RequestMapping("/save11")
    @ResponseBody
    public void save11(String username, int age) {

        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/save10")
    @ResponseBody
    public User save10() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lilei");
        user.setAge(30);

//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(user);

        return user;
    }

    @RequestMapping("/save9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lilei");
        user.setAge(30);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping("/save7")
    @ResponseBody // 告知SpringMVC框架不进行跳转。直接写入字符串。
    public String save7() {
        return "hello xiaoming";
    }

    @RequestMapping("/save6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello spring mvc");
    }

    @RequestMapping("/save5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("name", "我很快乐");
        return "success";
    }

    @RequestMapping(value="/quick4")
    public String save4(Model model){
        model.addAttribute("username","姓名");
        return "success";
    }

    @RequestMapping(value="/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","zhangsan");
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping("/save2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "lisi");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save() {
        System.out.println("Controller sava running...");
        return "success";
    }

}
