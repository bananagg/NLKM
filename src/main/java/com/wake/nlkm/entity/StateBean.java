package com.wake.nlkm.entity;

/**
 * @Author Ganty
 * @Date 2020/8/27
 * @Des
 */
public class StateBean {

    private Integer id;
    private Integer state;

    public StateBean(Integer id, Integer state) {
        this.id = id;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
