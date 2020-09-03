package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Vocabulary {
    private Integer id;

    private String wordId;

    private String word;

    private String pinyin;

    private String level;

    private String basicmean;

    private String detailmean;

    private String synonym;

    private String antonym;

    private String baike;

    private Integer checkState;
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

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId == null ? null : wordId.trim();
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getBasicmean() {
        return basicmean;
    }

    public void setBasicmean(String basicmean) {
        this.basicmean = basicmean == null ? null : basicmean.trim();
    }

    public String getDetailmean() {
        return detailmean;
    }

    public void setDetailmean(String detailmean) {
        this.detailmean = detailmean == null ? null : detailmean.trim();
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