package com.ex.seed.args;

import lombok.Data;

@Data
public class UserInfoArg extends PageArg{

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String userId;

    /**
     * 密码
     */
    private String password;


    public static UserInfoArg init(String userId,String password){
        UserInfoArg arg = new UserInfoArg();
        arg.setUserId(userId);
        arg.setPassword(password);
        return arg;
    }

}
