/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yangle
 * @version $Id SeleniumMontitoring.java, v 0.1 2017-01-21 下午5:18 yangle Exp $$
 */
@SpringBootApplication
@EnableScheduling
public class Base {

    public static void main(String arg[]) {

        SpringApplication.run(Base.class, arg);
    }

}
