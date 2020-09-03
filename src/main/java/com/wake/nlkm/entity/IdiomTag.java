package com.wake.nlkm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class IdiomTag {
    private Integer id;

    private String tagName;

    private String tagNameId;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
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