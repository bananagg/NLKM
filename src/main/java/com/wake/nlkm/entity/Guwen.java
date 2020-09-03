package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@Api(value = "")
@ApiModel(value = "古文对象", description = "古文对象")
public class Guwen {
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;

    @ApiModelProperty(value = "古诗标题", name = "title", required = true)
    private String title;

    @ApiModelProperty(value = "古诗朝代", name = "dynasty")
    private String dynasty;

    @ApiModelProperty(value = "古诗作者", name = "writer")
    private String writer;

    @ApiModelProperty(value = "古诗内容", name = "content")
    private String content;

    @ApiModelProperty(value = "古诗类型", name = "type")
    private String type;

    @ApiModelProperty(value = "古诗注解", name = "remark")
    private String remark;

    @ApiModelProperty(value = "赏析", name = "shangxi")
    private String shangxi;

    @ApiModelProperty(value = "翻译", name = "translation")
    private String translation;

    @ApiModelProperty(value = "map3 链接", name = "audiourl")
    private String audiourl;

    @ApiModelProperty(value = "是否删除", name = "isDelete")
    private Integer isDelete;

    @ApiModelProperty(value = "审核状态", name = "checkState")
    private Integer checkState;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", name = "createtime")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", name = "updatetime")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getShangxi() {
        return shangxi;
    }

    public void setShangxi(String shangxi) {
        this.shangxi = shangxi == null ? null : shangxi.trim();
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation == null ? null : translation.trim();
    }

    public String getAudiourl() {
        return audiourl;
    }

    public void setAudiourl(String audiourl) {
        this.audiourl = audiourl == null ? null : audiourl.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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