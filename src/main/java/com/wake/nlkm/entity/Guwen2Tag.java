package com.wake.nlkm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Guwen2Tag {
    private Integer id;

    private Integer guwenId;

    private Integer tagId;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuwenId() {
        return guwenId;
    }

    public void setGuwenId(Integer guwenId) {
        this.guwenId = guwenId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}