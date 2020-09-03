package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "术语定义对象", description = "术语定义对象")
public class TermsDefined {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "术语名称", name = "name")
    private String name;
    @ApiModelProperty(value = "详细信息", name = "detailMean")
    private String detailMean;
    @ApiModelProperty(value = "类型", name = "type")
    private String type;
    @ApiModelProperty(value = "例子", name = "example")
    private String example;
    @ApiModelProperty(value = "审核状态", name = "审核状态")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetailMean() {
        return detailMean;
    }

    public void setDetailMean(String detailMean) {
        this.detailMean = detailMean == null ? null : detailMean.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example == null ? null : example.trim();
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