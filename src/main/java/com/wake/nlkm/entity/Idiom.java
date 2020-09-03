package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Idiom {
    private Integer id;

    private String word;

    private String pinyin;

    private String basicMean;

    private String detailMean;

    private String source;

    private String example;

    private String synonym;

    private String antonym;

    private String baike;

    private String miyu;

    private Integer checkState;

    private Integer isDelete;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
        this.word = word == null ? null : word.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getBasicMean() {
        return basicMean;
    }

    public void setBasicMean(String basicMean) {
        this.basicMean = basicMean == null ? null : basicMean.trim();
    }

    public String getDetailMean() {
        return detailMean;
    }

    public void setDetailMean(String detailMean) {
        this.detailMean = detailMean == null ? null : detailMean.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example == null ? null : example.trim();
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym == null ? null : synonym.trim();
    }

    public String getAntonym() {
        return antonym;
    }

    public void setAntonym(String antonym) {
        this.antonym = antonym == null ? null : antonym.trim();
    }

    public String getBaike() {
        return baike;
    }

    public void setBaike(String baike) {
        this.baike = baike == null ? null : baike.trim();
    }

    public String getMiyu() {
        return miyu;
    }

    public void setMiyu(String miyu) {
        this.miyu = miyu == null ? null : miyu.trim();
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