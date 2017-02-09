/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s.dao;

import com.zs5s.entity.SeleniumInfo;

import java.util.Date;
import java.util.List;

/**
 * @author yangle
 * @version $Id SeleniumInfoDaoImpl.java, v 0.1 2017-01-22 下午4:44 yangle Exp $$
 */
public interface SeleniumInfoDao {
    SeleniumInfo getSeleniumInfo(int id);
    List<SeleniumInfo> getSeleniumInfoList(List<Integer> ids);
    int insertSeleniumInfo(SeleniumInfo seleniumInfo);
    int deleteSeleniumInfo(SeleniumInfo seleniumInfo);
    int updateSeleniumInfo(SeleniumInfo seleniumInfo);
    List<SeleniumInfo> findAll();
    SeleniumInfo findLast();
}