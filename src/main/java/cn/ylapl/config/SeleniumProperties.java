/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

/**
 * selenium grid获取json数据接口
 * @author yangle
 * @version $Id SeleniumProperties.java, v 0.1 2017-01-22 下午12:21 yangle Exp $$
 */
//@Configuration
//@ConfigurationProperties(ignoreUnknownFields = false,prefix = "seleniumGrid")
public class SeleniumProperties {
    @NotNull
    private String url;

    public String getUrl() {
        return url + "/grid/admin/CustomServlet/";
    }

    public void setUrl(String url) {
        this.url = url;
    }
}