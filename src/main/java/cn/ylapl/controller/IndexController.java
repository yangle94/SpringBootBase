package cn.ylapl.controller;

import cn.ylapl.service.SeleniumInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangle
 * @version $Id IndexController.java, v 0.1 2017-02-08 下午1:30 yangle Exp $$
 */
@RestController
@RequestMapping("jpush")
public class IndexController {

    @Autowired
    private SeleniumInfoService seleniumInfoService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "记录ID", required = true, dataType = "String", paramType = "Query")
    })
    @ApiOperation("测试接口")
    @RequestMapping("/")
    public String index(@RequestParam String id) {
        return seleniumInfoService.test();
    }

    public static IndexController getIndex() {
        return new IndexController();
    }
}