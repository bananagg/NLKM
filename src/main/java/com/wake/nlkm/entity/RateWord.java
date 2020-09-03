package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RateWord {
    private Integer id;

    private String word;

    private String redical;

    private Byte isDel;

    private Byte checkState;
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

    public String getRedical() {
        return redical;
    }

    public void setRedical(String redical) {
        this.redical = redical == null ? null : redical.trim();
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public Byte getCheckState() {
        return checkState;
    }

    public void setCheckState(Byte checkState) {
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