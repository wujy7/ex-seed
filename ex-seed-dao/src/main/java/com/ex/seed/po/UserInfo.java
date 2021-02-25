package com.ex.seed.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
* Created by Mybatis Generator 2021/02/24
*/
@Data
@NoArgsConstructor
public class UserInfo implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户名
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
     * 所在 县（市，区）id
     */
    private String districtId;

    /**
     * 所在 县（市，区）
     */
    private String districtName;

    /**
     * 部门
     */
    private String department;

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

    /**
     * 用户角色列表
     */
    private String roleListJson;

    /**
     * 账号状态（1停用，0正常）
     */
    private String type;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除（1:是，0:否）
     */
    private Integer isDeleted;

    /**
     * user_info
     */
    private static final long serialVersionUID = 1L;
}