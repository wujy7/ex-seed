package com.ex.seed.dao;

import com.ex.seed.args.UserInfoArg;
import com.ex.seed.po.UserInfo;

public interface UserInfoDaoService {

    UserInfo getUserInfo(UserInfoArg arg);

}
