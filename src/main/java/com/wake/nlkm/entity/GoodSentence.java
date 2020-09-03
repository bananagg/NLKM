package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
@ApiModel(value = "优美语句对象", description = "优美语句对象")
public class GoodSentence {

    @ApiModelProperty(value = "id", name = "id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "内容", name = "content", required = true)
    private String content;
    @ApiModelProperty(value = "类型", name = "type")
    private String type;
    @ApiModelProperty(value = "标签", name = "tag")
    private String tag;
    @ApiModelProperty(value = "审核状态", name = "checkState")
    private Integer checkState;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间",name="createtime")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间",name="updatetime")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
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