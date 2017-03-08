/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl.service.Impl;

import cn.ylapl.service.SeleniumInfoService;
import org.springframework.stereotype.Service;

/**
 * @author yangle
 * @version $Id SeleniumInfoServiceImpl.java, v 0.1 2017-01-22 下午4:42 yangle Exp $$
 */
@Service
public class SeleniumInfoServiceImpl implements SeleniumInfoService {

    @Override
    public String test() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}