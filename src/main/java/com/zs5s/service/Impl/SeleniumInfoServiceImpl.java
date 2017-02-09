/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s.service.Impl;

import com.zs5s.dao.SeleniumInfoDao;
import com.zs5s.entity.SeleniumInfo;
import com.zs5s.service.SeleniumInfoService;
import com.zs5s.util.logger.Zs5sLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangle
 * @version $Id SeleniumInfoServiceImpl.java, v 0.1 2017-01-22 下午4:42 yangle Exp $$
 */
@Service
public class SeleniumInfoServiceImpl implements SeleniumInfoService {
    private final SeleniumInfoDao seleniumInfoDao;

    @Autowired
    public SeleniumInfoServiceImpl(SeleniumInfoDao seleniumInfoDao) {
        this.seleniumInfoDao = seleniumInfoDao;
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
        Zs5sLogger.info(this,"list size:" + ids.size());
        return seleniumInfoDao.getSeleniumInfoList(ids);
    }

    /**
     * 存储seleniumInfo
     * @param seleniumInfo
     * @return
     */
    @Override
    public int insertSeleniumInfo(SeleniumInfo seleniumInfo) {
        Zs5sLogger.info(this,"seleniumInfo id:" + seleniumInfo.getId());
        return seleniumInfoDao.insertSeleniumInfo(seleniumInfo);
    }

    /**
     * 删除seleniumInfo
     * @param seleniumInfo
     * @return
     */
    @Override
    public int deleteSeleniumInfo(SeleniumInfo seleniumInfo) {
        Zs5sLogger.info(this,"seleniumInfo id:" + seleniumInfo.getId());
        return seleniumInfoDao.deleteSeleniumInfo(seleniumInfo);
    }

    /**
     * 更新seleniumInfo
     * @param seleniumInfo
     * @return
     */
    @Override
    public int updateSeleniumInfo(SeleniumInfo seleniumInfo) {
        Zs5sLogger.info(this,"seleniumInfo id:" + seleniumInfo.getId());
        return seleniumInfoDao.updateSeleniumInfo(seleniumInfo);
    }

    @Override
    public List<SeleniumInfo> findAll() {
        Zs5sLogger.info(this,"seleniumInfo findAll");
        return seleniumInfoDao.findAll();
    }

    @Override
    public SeleniumInfo findLast() {
        Zs5sLogger.info(this,"seleniumInfo findAll");
        return seleniumInfoDao.findLast();
    }
}