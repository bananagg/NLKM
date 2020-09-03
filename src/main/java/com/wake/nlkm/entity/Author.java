package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class Author {
    @ApiModelProperty(value = "id", name = "id", dataType = "Integer")
    private Integer id;
    @ApiModelProperty(value = "人物id", name = "personId", dataType = "String")
    private String personId;
    @ApiModelProperty(value = "人物名称", name = "name", dataType = "String")
    private String name;
    @ApiModelProperty(value = "朝代", name = "dynasty", dataType = "String")
    private String dynasty;
    @ApiModelProperty(value = "诗词数量", name = "shiciCount", dataType = "Integer")
    private Integer shiciCount;
    @ApiModelProperty(value = "简介", name = "intro", dataType = "String")
    private String intro;
    @ApiModelProperty(value = "轶事典故", name = "allusion", dataType = "String")
    private String allusion;
    @ApiModelProperty(value = "人物生平", name = "life", dataType = "String")
    private String life;
    @ApiModelProperty(value = "成就", name = "achievement", dataType = "String")
    private String achievement;
    @ApiModelProperty(value = "评价", name = "evaluation", dataType = "String")
    private String evaluation;
    @ApiModelProperty(value = "人物简介2", name = "simpleIntro", dataType = "String")
    private String simpleIntro;
    @ApiModelProperty(value = "详细信息", name = "detailIntro", dataType = "String")
    private String detailIntro;
    @ApiModelProperty(value = "头像url", name = "headImageUrl", dataType = "String")
    private String headImageUrl;
    @ApiModelProperty(value = "标记", name = "source", dataType = "Integer")
    private Integer source;
    @ApiModelProperty(value = "审核状态", name = "checkState", dataType = "Integer")
    private Integer checkState;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", name = "createtime", dataType = "Date")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", name = "updatetime", dataType = "Date")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public Integer getShiciCount() {
        return shiciCount;
    }

    public void setShiciCount(Integer shiciCount) {
        this.shiciCount = shiciCount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getAllusion() {
        return allusion;
    }

    public void setAllusion(String allusion) {
        this.allusion = allusion == null ? null : allusion.trim();
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life == null ? null : life.trim();
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public String getSimpleIntro() {
        return simpleIntro;
    }

    public void setSimpleIntro(String simpleIntro) {
        this.simpleIntro = simpleIntro == null ? null : simpleIntro.trim();
    }

    public String getDetailIntro() {
        return detailIntro;
    }

    public void setDetailIntro(String detailIntro) {
        this.detailIntro = detailIntro == null ? null : detailIntro.trim();
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl == null ? null : headImageUrl.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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