package com.wake.nlkm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Idiom2Tag {
    private Integer id;

    private String idiomId;

    private String tagNameId;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdiomId() {
        return idiomId;
    }

    public void setIdiomId(String idiomId) {
        this.idiomId = idiomId == null ? null : idiomId.trim();
    }

    public String getTagNameId() {
        return tagNameId;
    }

    public void setTagNameId(String tagNameId) {
        this.tagNameId = tagNameId == null ? null : tagNameId.trim();
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