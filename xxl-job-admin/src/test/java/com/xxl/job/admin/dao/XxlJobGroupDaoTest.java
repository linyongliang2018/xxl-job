package com.xxl.job.admin.dao;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.xxl.job.admin.core.model.XxlJobGroup;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class XxlJobGroupDaoTest {

    //    @Resource
    @Autowired
    private XxlJobGroupDao xxlJobGroupDao;

    @Test
    public void test() {
        List<XxlJobGroup> allJobGroupList = new LambdaQueryChainWrapper<>(xxlJobGroupDao).
                orderByAsc(Arrays.asList(XxlJobGroup::getAppName, XxlJobGroup::getTitle, XxlJobGroup::getId)).list();
        List<XxlJobGroup> list = new LambdaQueryChainWrapper<>(xxlJobGroupDao).eq(XxlJobGroup::getAddressType, 0).
                orderByAsc(Arrays.asList(XxlJobGroup::getAppName, XxlJobGroup::getTitle, XxlJobGroup::getId)).list();
        XxlJobGroup group = new XxlJobGroup();
        group.setAppName("setAppName");
        group.setTitle("setTitle");
        group.setAddressType(0);
        group.setAddressList("setAddressList");
        group.setUpdateTime(new Date());
        int save = xxlJobGroupDao.insert(group);

        XxlJobGroup xxlJobGroup = xxlJobGroupDao.selectById(group.getId());

        xxlJobGroup.setAppName("setAppName2");
        xxlJobGroup.setTitle("setTitle2");
        xxlJobGroup.setAddressType(2);
        xxlJobGroup.setAddressList("setAddressList2");
        xxlJobGroup.setUpdateTime(new Date());
        xxlJobGroupDao.updateById(xxlJobGroup);
        xxlJobGroupDao.deleteById(group.getId());
    }

}
