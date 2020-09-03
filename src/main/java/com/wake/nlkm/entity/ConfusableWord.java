package com.wake.nlkm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ConfusableWord {
    private Integer id;

    private String word;

    private String tongyintongdiao;

    private String tongyinyidiao;

    private String jinyintongdiao;

    private String jinyinyiao;

    private String sameRadical;

    private String sameStroke;

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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getTongyintongdiao() {
        return tongyintongdiao;
    }

    public void setTongyintongdiao(String tongyintongdiao) {
        this.tongyintongdiao = tongyintongdiao == null ? null : tongyintongdiao.trim();
    }

    public String getTongyinyidiao() {
        return tongyinyidiao;
    }

    public void setTongyinyidiao(String tongyinyidiao) {
        this.tongyinyidiao = tongyinyidiao == null ? null : tongyinyidiao.trim();
    }

    public String getJinyintongdiao() {
        return jinyintongdiao;
    }

    public void setJinyintongdiao(String jinyintongdiao) {
        this.jinyintongdiao = jinyintongdiao == null ? null : jinyintongdiao.trim();
    }

    public String getJinyinyiao() {
        return jinyinyiao;
    }

    public void setJinyinyiao(String jinyinyiao) {
        this.jinyinyiao = jinyinyiao == null ? null : jinyinyiao.trim();
    }

    public String getSameRadical() {
        return sameRadical;
    }

    public void setSameRadical(String sameRadical) {
        this.sameRadical = sameRadical == null ? null : sameRadical.trim();
    }

    public String getSameStroke() {
        return sameStroke;
    }

    public void setSameStroke(String sameStroke) {
        this.sameStroke = sameStroke == null ? null : sameStroke.trim();
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