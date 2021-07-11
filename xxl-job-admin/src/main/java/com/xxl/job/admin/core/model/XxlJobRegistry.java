package com.xxl.job.admin.core.model;

import lombok.Data;

import java.util.Date;

/**
 * @author xuxueli
 * @date 16/9/30
 */
@Data
public class XxlJobRegistry {

    private int id;
    private String registryGroup;
    private String registryKey;
    private String registryValue;
    private Date updateTime;


}
