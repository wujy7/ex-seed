package com.ex.seed.biz.impl;

import com.ex.seed.args.UserInfoArg;
import com.ex.seed.assemble.UserInfoAssemble;
import com.ex.seed.biz.UserInfoService;
import com.ex.seed.bo.UserInfoBo;
import com.ex.seed.dao.UserInfoDaoService;
import com.ex.seed.po.UserInfo;
import com.ex.seed.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDaoService userInfoDaoService;

    /**
     * 根据用户账号，用户密码查询用户账号信息
     * 用户账号（必填）
     * 用户密码（必填）
     * @param arg
     * @return
     */
    @Override
    public UserInfoBo getUserInfo(UserInfoArg arg){
        UserInfoBo userInfo = CacheUtil.get(arg.getUserId(),UserInfoBo.class);
        if (userInfo == null){
            UserInfo po = userInfoDaoService.getUserInfo(arg);
            userInfo = UserInfoAssemble.po2Bo(po);
            if (userInfo!=null){
                CacheUtil.put(arg.getUserId(),userInfo);
            }
        }
        return userInfo;
    }

}
