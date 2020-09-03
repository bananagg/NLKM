package com.wake.nlkm.entity;

import io.swagger.annotations.ApiModel;

/**
 * @Author Ganty
 * @Date 2020/9/1
 * @Des
 */
@ApiModel(value = "级别对象", description = "级别对象")
public class LevelBean {

    private Integer id;
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
