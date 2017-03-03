/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl.service.Impl;

import cn.ylapl.config.SeleniumProperties;
import cn.ylapl.dao.SeleniumInfoDao;
import cn.ylapl.entity.SeleniumInfo;
import cn.ylapl.service.SeleniumInfoService;
import cn.ylapl.util.logger.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yangle
 * @version $Id SeleniumInfoServiceImpl.java, v 0.1 2017-01-22 下午4:42 yangle Exp $$
 */
//@Service
public class SeleniumInfoServiceImpl implements SeleniumInfoService {
    private final SeleniumInfoDao seleniumInfoDao;

    private  final SeleniumProperties seleniumProperties;

    @Autowired
    public SeleniumInfoServiceImpl(SeleniumInfoDao seleniumInfoDao, SeleniumProperties seleniumProperties) {
        this.seleniumInfoDao = seleniumInfoDao;
        this.seleniumProperties = seleniumProperties;
    }

    @Override
    public SeleniumInfo getSeleniumInfo(int id) {
        return seleniumInfoDao.getSeleniumInfo(id);
    }

    /**
     * 根据id list获取seleniuminfo list
     * @param ids
     * @return
     */
    @Override
    public List<SeleniumInfo> getSeleniumInfoList(List<Integer> ids) {
        LogUtil.info(this,"list size:" + ids.size());
        return seleniumInfoDao.getSeleniumInfoList(ids);
    }

    /**
     * 存储seleniumInfo
     * @param seleniumInfo
     * @return
     */
    @Override
    public int insertSeleniumInfo(SeleniumInfo seleniumInfo) {
        LogUtil.info(this,"seleniumInfo id:" + seleniumInfo.getId());
        return seleniumInfoDao.insertSeleniumInfo(seleniumInfo);
    }

    /**
     * 删除seleniumInfo
     * @param seleniumInfo
     * @return
     */
    @Override
    public int deleteSeleniumInfo(SeleniumInfo seleniumInfo) {
        LogUtil.info(this,"seleniumInfo id:" + seleniumInfo.getId());
        return seleniumInfoDao.deleteSeleniumInfo(seleniumInfo);
    }

    /**
     * 更新seleniumInfo
     * @param seleniumInfo
     * @return
     */
    @Override
    public int updateSeleniumInfo(SeleniumInfo seleniumInfo) {
        LogUtil.info(this,"seleniumInfo id:" + seleniumInfo.getId());
        return seleniumInfoDao.updateSeleniumInfo(seleniumInfo);
    }

    @Override
    public List<SeleniumInfo> findAll() {
        LogUtil.info(this,"seleniumInfo findAll");
        return seleniumInfoDao.findAll();
    }

    @Override
    public SeleniumInfo findLast() {
        LogUtil.info(this,"seleniumInfo findAll");
        return seleniumInfoDao.findLast();
    }
}