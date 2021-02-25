package com.ex.seed.bo;

import lombok.Data;

@Data
public class UserInfoBo {

    /**
     * 账号
     */
    private String userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 座机号码
     */
    private String landline;

    /**
     * 电子邮箱
     */
    private String eMail;

    /**
     * 微信号
     */
    private String weChat;

}
