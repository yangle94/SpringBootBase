/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.zs5s.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangle
 * @version $Id IndexController.java, v 0.1 2017-02-08 下午1:30 yangle Exp $$
 */
@Controller
@RequestMapping
public class IndexController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "记录ID", required = true, dataType = "String", paramType = "Query")
    })
    @RequestMapping("/")
    public String index(@RequestParam String id) {
        return "";
    }
}