package com.xxl.job.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxl.job.admin.core.model.XxlJobGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 去除无用的public修饰符
 * 所谓冤有头债有主,依据:摘自ON JAVA8 : "in fact, interfaces only allow public methods and if you don’t provide an access specifier"
 * 集成mybatis-plus,兼容多种数据库
 *
 * @author xuxueli, linyongliang
 * @date 16/9/30
 */
@Mapper
public interface XxlJobGroupDao extends BaseMapper<XxlJobGroup> {

    List<XxlJobGroup> pageList(@Param("offset") int offset,
                               @Param("pagesize") int pagesize,
                               @Param("appName") String appName,
                               @Param("title") String title);

    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize,
                      @Param("appName") String appName,
                      @Param("title") String title);

}
