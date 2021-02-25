package com.ex.seed.utils;

import com.ex.seed.bo.UserInfoBo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {

    public static UserInfoBo getUserInfo() {
        UserInfoBo userDTO = null;
        HttpSession session = SpringUtil.getSession();
        if (session != null){
            userDTO = (UserInfoBo) session.getAttribute("logonUser");
        }
        return userDTO;
    }

    public static UserInfoBo getUserInfo(HttpServletRequest request) {
        UserInfoBo userDTO = null;
        if (request != null){
            HttpSession session = request.getSession();
            userDTO = (UserInfoBo) session.getAttribute("logonUser");
        }
        return userDTO;
    }

    public static void setUserInfo(UserInfoBo userInfo) {
        SpringUtil.getSession().setAttribute("logonUser",userInfo);
    }

    public static void removeUserInfo() {
        SpringUtil.getSession().removeAttribute("logonUser");
    }

}
