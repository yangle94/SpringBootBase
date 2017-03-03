/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */

import cn.ylapl.Base;
import cn.ylapl.mapper.SeleniumInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangle
 * @version $Id SeleniumInfoTest.java, v 0.1 2017-02-05 下午12:58 yangle Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Base.class)
public class SeleniumInfoTest {
    @Autowired
    private SeleniumInfoMapper seleniumInfoMapper;

    @Test
    public void findAll() {
        seleniumInfoMapper.findAll();
    }


}