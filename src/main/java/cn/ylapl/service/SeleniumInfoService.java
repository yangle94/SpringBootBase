/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl.service;

import cn.ylapl.entity.SeleniumInfo;

import java.util.List;

/**
 * @author yangle
 * @version $Id SeleniumInfoService.java, v 0.1 2017-01-22 下午4:42 yangle Exp $$
 */
public interface SeleniumInfoService {
    SeleniumInfo getSeleniumInfo(int id);
    List<SeleniumInfo> getSeleniumInfoList(List<Integer> ids);
    int insertSeleniumInfo(SeleniumInfo seleniumInfoDao);
    int deleteSeleniumInfo(SeleniumInfo seleniumInfoDao);
    int updateSeleniumInfo(SeleniumInfo seleniumInfoDao);
    List<SeleniumInfo> findAll();
    SeleniumInfo findLast();
}