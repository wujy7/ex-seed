package com.ex.seed.mapper;

import com.ex.seed.po.UserInfo;
import com.ex.seed.po.UserInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* Created by Mybatis Generator 2021/02/24
*/
public interface UserInfoMapper {
    /**
     *
     * @mbg.generated 2021-02-24
     */
    long countByExample(UserInfoExample example);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int deleteByExample(UserInfoExample example);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int deleteByPrimaryKey(Map<String, Object> paramMap);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int insert(UserInfo record);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int insertSelective(UserInfo record);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    List<UserInfo> selectByExample(UserInfoExample example);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    UserInfo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     *
     * @mbg.generated 2021-02-24
     */
    int updateByPrimaryKey(UserInfo record);

    Map<String, Object> sumByExample(UserInfoExample example);
}