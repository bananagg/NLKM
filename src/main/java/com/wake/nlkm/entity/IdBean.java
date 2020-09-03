package com.wake.nlkm.entity;

/**
 * @Author Ganty
 * @Date 2020/8/27
 * @Des
 */
public class IdBean {

    private Integer pk_id;

    public IdBean(Integer id) {
        this.pk_id = id;
    }

    public Integer getId() {
        return pk_id;
    }

    public void setId(Integer id) {
        this.pk_id = id;
    }
}
