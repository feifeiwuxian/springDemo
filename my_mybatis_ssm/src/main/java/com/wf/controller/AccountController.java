package com.wf.controller;

import com.wf.domain.Account;
import com.wf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    // 保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) {
        accountService.save(account);
      return "保存成功";
    }

    // 查询
    public ModelAndView findAll() {
        List<Account> list = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accountList", list);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
