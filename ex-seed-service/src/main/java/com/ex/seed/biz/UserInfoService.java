package com.ex.seed.biz;

import com.ex.seed.args.UserInfoArg;
import com.ex.seed.bo.UserInfoBo;

public interface UserInfoService {

    /**
     * 根据用户账号，用户密码查询用户账号信息
     * 用户账号（必填）
     * 用户密码（必填）
     * @param arg
     * @return
     */
    UserInfoBo getUserInfo(UserInfoArg arg);

}
