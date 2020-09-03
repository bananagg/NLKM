package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@ApiModel(value = "字对象", description = "字对象")
public class Word {

    @ApiModelProperty(value="id",name="id",example="1")
    private Integer id;
    @ApiModelProperty(value="字",name="word",required=true)
    private String word;
    @ApiModelProperty(value="字编码",name="word_id",required=false)
    private String word_id;
    @ApiModelProperty(value="拼音",name="pinyin",required=false)
    private String pinyin;
    @ApiModelProperty(value="部首",name="redical",required=false)
    private String redical;
    @ApiModelProperty(value="笔画",name="stroke_count",required=false)
    private String stroke_count;
    @ApiModelProperty(value="繁体",name="traditional",required=false)
    private String traditional;
    @ApiModelProperty(value="是否为会意字",name="is_huiyizi",required=false)
    private Integer is_huiyizi;
    @ApiModelProperty(value="是否为形声字",name="is_xingshengzi",required=false)
    private Integer is_xingshengzi;
    @ApiModelProperty(value="是否为生僻字",name="is_rate_word",required=false)
    private Integer is_rate_word;
    @ApiModelProperty(value="字级别",name="level",required=false)
    private Integer level;
    @ApiModelProperty(value="五笔",name="wubi",required=false)
    private String wubi;
    @ApiModelProperty(value="基础解释",name="basic_mean",required=false)
    private String basic_mean;
    @ApiModelProperty(value="详细解释",name="detail_mean",required=false)
    private String detail_mean;
    @ApiModelProperty(value="组词样例",name="zuci",required=false)
    private String zuci;
    @ApiModelProperty(value="出处",name="source",required=false)
    private String source;
    @ApiModelProperty(value="例句",name="liju",required=false)
    private String liju;
    @ApiModelProperty(value="近义词",name="synonym",required=false)
    private String synonym;
    @ApiModelProperty(value="反义词",name="antonym",required=false)
    private String antonym;
    @ApiModelProperty(value="谜语",name="miyu",required=false)
    private String miyu;
    @ApiModelProperty(value="百科解释",name="baike",required=false)
    private String baike;
    @ApiModelProperty(value = "", name = "")
    private Integer checkState;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间",name="createtime",required=false)
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间",name="updatetime",required=false)
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord_id() {
        return word_id;
    }

    public void setWord_id(String word_id) {
        this.word_id = word_id;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getRedical() {
        return redical;
    }

    public void setRedical(String redical) {
        this.redical = redical;
    }

    public String getStroke_count() {
        return stroke_count;
    }

    public void setStroke_count(String stroke_count) {
        this.stroke_count = stroke_count;
    }

    public String getTraditional() {
        return traditional;
    }

    public void setTraditional(String traditional) {
        this.traditional = traditional;
    }

    public Integer getIs_huiyizi() {
        return is_huiyizi;
    }

    public void setIs_huiyizi(Integer is_huiyizi) {
        this.is_huiyizi = is_huiyizi;
    }

    public Integer getIs_xingshengzi() {
        return is_xingshengzi;
    }

    public void setIs_xingshengzi(Integer is_xingshengzi) {
        this.is_xingshengzi = is_xingshengzi;
    }

    public Integer getIs_rate_word() {
        return is_rate_word;
    }

    public void setIs_rate_word(Integer is_rate_word) {
        this.is_rate_word = is_rate_word;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getWubi() {
        return wubi;
    }

    public void setWubi(String wubi) {
        this.wubi = wubi;
    }

    public String getBasic_mean() {
        return basic_mean;
    }

    public void setBasic_mean(String basic_mean) {
        this.basic_mean = basic_mean;
    }

    public String getDetail_mean() {
        return detail_mean;
    }

    public void setDetail_mean(String detail_mean) {
        this.detail_mean = detail_mean;
    }

    public String getZuci() {
        return zuci;
    }

    public void setZuci(String zuci) {
        this.zuci = zuci;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLiju() {
        return liju;
    }

    public void setLiju(String liju) {
        this.liju = liju;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public String getAntonym() {
        return antonym;
    }

    public void setAntonym(String antonym) {
        this.antonym = antonym;
    }

    public String getMiyu() {
        return miyu;
    }

    public void setMiyu(String miyu) {
        this.miyu = miyu;
    }

    public String getBaike() {
        return baike;
    }

    public void setBaike(String baike) {
        this.baike = baike;
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
