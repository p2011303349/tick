package com.qianfeng.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SysDepart {
    private Integer id;

    private Integer did;

    private String name;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}