package com.ex.seed.controller;

import com.ex.seed.args.UserInfoArg;
import com.ex.seed.biz.UserInfoService;
import com.ex.seed.bo.UserInfoBo;
import com.ex.seed.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;


/**
 * 登录接口类，提供系统登录服务接口
 */
@Slf4j
@Controller
@RequestMapping("/sso")
public class SsoController {


    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/login")
    public String login(String service, ModelMap modelMap) {
        // service不能为空
        if (StringUtils.isEmpty(service)) {
            modelMap.put("message", "未指定服务地址");
            return "error";
        }
        UserInfoBo userInfo = UserUtil.getUserInfo();
        if (userInfo != null){
            return "redirect:" + service;
        }

        /*
         * 用户没有SSO会话，因此提供登录表单
         */
        log.info("CAS Protocol flow 2 服务端收到登录GET请求，跳转至登录页面");
        modelMap.put("service", service);
        return "login";
    }


    /**
     * 单点登录地址
     */
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login(String userId, String passWord, String service, ModelMap modelMap, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        /*
         * 用户名，密码和登录ticket在POST的body中
         */
        UserInfoBo userInfo = UserUtil.getUserInfo();
        if (userInfo != null){
            return "redirect:" + service;
        }
        log.info("CAS Protocol flow 3 服务端验证用户登录");
        userInfo = userInfoService.getUserInfo(UserInfoArg.init(userId,passWord));

        if (userInfo == null || StringUtils.isEmpty(userId)) {
            modelMap.put("error", "用户名或密码错误！");
            modelMap.put("service", service);
            return "login";
        } else {
            log.info("CAS Protocol flow 4 服务端登录成功，生成一系列CAS验证对象");
            UserUtil.setUserInfo(userInfo);
            return "redirect:" + service;
        }
    }


    /**
     * 单点登出地址
     */
    @GetMapping("/logout")
    public void logout(HttpServletResponse response) {
        try {
            UserUtil.removeUserInfo();
            response.getWriter().print("succes!");
        } catch (Exception e) {
            log.error("logout:",e);
        }
    }


}
