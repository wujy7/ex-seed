package com.ex.seed.assemble;

import com.ex.seed.bo.UserInfoBo;

public class UserInfoAssemble {

    public static UserInfoBo po2Bo(com.ex.seed.po.UserInfo po) {
        if (po == null) {
            return null;
        }
        UserInfoBo ssoUser = new UserInfoBo();
        ssoUser.setUserId(po.getUserId());
        ssoUser.setPassword(po.getPassword());
        ssoUser.setNickName(po.getNickName());
        ssoUser.setIdCard(po.getIdCard());
        ssoUser.setSex(po.getSex());
        ssoUser.setPhone(po.getPhone());
        ssoUser.setLandline(po.getLandline());
        ssoUser.setEMail(po.getEMail());
        ssoUser.setWeChat(po.getWeChat());
        return ssoUser;
    }

}
