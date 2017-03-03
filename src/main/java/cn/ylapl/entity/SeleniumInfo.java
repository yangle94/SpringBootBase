/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package cn.ylapl.entity;

import java.util.Date;

/**
 * @author yangle
 * @version $Id SeleniumInfo.java, v 0.1 2017-01-22 下午3:56 yangle Exp $$
 */
public class SeleniumInfo {
    /**
     * id
     */
    private int id;
    /**
     * 信息
     */
    private String info;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 时间
     */
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "SeleniumInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", ip='" + ip + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}