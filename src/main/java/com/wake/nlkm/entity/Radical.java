package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class Radical {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "偏旁", name = "radical")
    private String radical;
    @ApiModelProperty(value = "偏旁说法", name = "radicalExplain")
    private String radicalExplain;
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

    public String getRadical() {
        return radical;
    }

    public void setRadical(String radical) {
        this.radical = radical == null ? null : radical.trim();
    }

    public String getRadicalExplain() {
        return radicalExplain;
    }

    public void setRadicalExplain(String radicalExplain) {
        this.radicalExplain = radicalExplain == null ? null : radicalExplain.trim();
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