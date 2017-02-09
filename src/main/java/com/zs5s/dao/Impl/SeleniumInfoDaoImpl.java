/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s.dao.Impl;

import com.zs5s.dao.SeleniumInfoDao;
import com.zs5s.entity.SeleniumInfo;
import com.zs5s.mapper.SeleniumInfoMapper;
import com.zs5s.util.logger.Zs5sLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author yangle
 * @version $Id SeleniumInfoDaoImpl.java, v 0.1 2017-01-22 下午4:45 yangle Exp $$
 */
@Component
public class SeleniumInfoDaoImpl implements SeleniumInfoDao {

    private final SeleniumInfoMapper seleniumInfoMapper;

    SeleniumInfoDaoImpl(@Autowired SeleniumInfoMapper seleniumInfoMapper) {
        this.seleniumInfoMapper = seleniumInfoMapper;
    }

    @Override
    public SeleniumInfo getSeleniumInfo(int id) {
        Zs5sLogger.info(this,"id:" + id);
        return seleniumInfoMapper.findById(id);
    }

    @Override
    public List<SeleniumInfo> getSeleniumInfoList(List<Integer> ids) {
        Zs5sLogger.info(this,"idsSize:" + ids.size());
        return seleniumInfoMapper.findListInIds(ids);
    }

    @Override
    public int insertSeleniumInfo(SeleniumInfo seleniumInfo) {
        Zs5sLogger.info(this,"id:" + seleniumInfo.getId());
        return seleniumInfoMapper.insert(seleniumInfo);
    }

    @Override
    public int deleteSeleniumInfo(SeleniumInfo seleniumInfo) {
        Zs5sLogger.info(this,"id:" + seleniumInfo.getId());
        return seleniumInfoMapper.deleteById(seleniumInfo.getId());
    }

    @Override
    public int updateSeleniumInfo(SeleniumInfo seleniumInfo) {
        Zs5sLogger.info(this,"id:" + seleniumInfo.getId());
        return seleniumInfoMapper.updateById(seleniumInfo);
    }

    @Override
    public List<SeleniumInfo> findAll() {
        Zs5sLogger.info(this,"findAll");
        return seleniumInfoMapper.findAll();
    }

    @Override
    public SeleniumInfo findLast() {
        Zs5sLogger.info(this,"findAll");
        return seleniumInfoMapper.findLast();
    }
}