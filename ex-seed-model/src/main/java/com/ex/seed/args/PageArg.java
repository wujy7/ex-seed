package com.ex.seed.args;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageArg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每页数据量
     */
    private Integer pageSize = 5;

    /**
     * 当前页
     */
    private Integer pageNo = 1;

}
