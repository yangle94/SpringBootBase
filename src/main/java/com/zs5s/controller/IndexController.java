/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangle
 * @version $Id IndexController.java, v 0.1 2017-02-08 下午1:30 yangle Exp $$
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "";
    }
}