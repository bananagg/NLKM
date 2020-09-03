package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "现代作家模型", description = "现代作家模型")
public class ModernWriter {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "姓名", name = "name")
    private String name;
    @ApiModelProperty(value = "中文名", name = "nameZh")
    private String nameZh;
    @ApiModelProperty(value = "别名", name = "alias")
    private String alias;
    @ApiModelProperty(value = "国籍", name = "nationality")
    private String nationality;
    @ApiModelProperty(value = "民族", name = "nation")
    private String nation;
    @ApiModelProperty(value = "出生地", name = "birthplace")
    private String birthplace;
    @ApiModelProperty(value = "出生日期", name = "birthdate")
    private String birthdate;
    @ApiModelProperty(value = "逝世日期", name = "deathdate")
    private String deathdate;
    @ApiModelProperty(value = "职业", name = "profession")
    private String profession;
    @ApiModelProperty(value = "信仰", name = "belief")
    private String belief;
    @ApiModelProperty(value = "祖籍", name = "ancestralHome")
    private String ancestralHome;
    @ApiModelProperty(value = "毕业院校", name = "university")
    private String university;
    @ApiModelProperty(value = "简介", name = "introduce")
    private String introduce;
    @ApiModelProperty(value = "作品", name = "production")
    private String production;
    @ApiModelProperty(value = "成就", name = "achievement")
    private String achievement;
    @ApiModelProperty(value = "是否删除", name = "isDelete")
    private Integer isDelete;
    @ApiModelProperty(value = "姓名", name = "checkState")
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

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate == null ? null : birthdate.trim();
    }

    public String getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(String deathdate) {
        this.deathdate = deathdate == null ? null : deathdate.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getBelief() {
        return belief;
    }

    public void setBelief(String belief) {
        this.belief = belief == null ? null : belief.trim();
    }

    public String getAncestralHome() {
        return ancestralHome;
    }

    public void setAncestralHome(String ancestralHome) {
        this.ancestralHome = ancestralHome == null ? null : ancestralHome.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production == null ? null : production.trim();
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement == null ? null : achievement.trim();
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