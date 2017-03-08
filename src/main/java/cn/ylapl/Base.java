/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
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
