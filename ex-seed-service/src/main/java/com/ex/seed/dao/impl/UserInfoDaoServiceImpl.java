package com.ex.seed.dao.impl;

import com.ex.seed.args.UserInfoArg;
import com.ex.seed.dao.UserInfoDaoService;
import com.ex.seed.mapper.UserInfoMapper;
import com.ex.seed.po.UserInfo;
import com.ex.seed.po.UserInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserInfoDaoServiceImpl implements UserInfoDaoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getUserInfo(UserInfoArg arg) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        if (arg==null|| StringUtils.isBlank(arg.getUserId())||StringUtils.isBlank(arg.getPassword())){
            return null;
        }
        criteria.andUserIdEqualTo(arg.getUserId());
        criteria.andPasswordEqualTo(arg.getPassword());
        List<UserInfo> userList = userInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)){
            return null;
        }
        return userList.get(0);
    }


}
