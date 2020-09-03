package com.wake.nlkm.utils;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * bbb
 * @Author Ganty
 * @Date 2020/8/18
 * @Des 返回分页
 */
public class RespPageBean {
    private Integer curPageIndex;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPageCount;

    private List<?> data;

    public RespPageBean() {
    }

    public RespPageBean(List<?> data) {
        this.data = data;
    }

    public RespPageBean(Integer total, List<?> data) {
        this.totalCount = total;
        this.data = data;
    }

    public RespPageBean(Integer curPageIndex, Integer pageSize, Integer totalCount, Integer totalPageCount, List<?> data) {
        this.curPageIndex = curPageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = totalPageCount;
        this.data = data;
    }

    public Integer getCurPageIndex() {
        return curPageIndex;
    }

    public void setCurPageIndex(Integer curPageIndex) {
        this.curPageIndex = curPageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public void setProperty(Integer totalCount, Integer curPage, Integer size){
        this.totalCount = totalCount;
        this.curPageIndex = curPage;
        System.out.println("--------------");
        System.out.println("totalCount = "+ totalCount);
        int pageCount = (int) Math.ceil((double)totalCount /size);
        this.totalPageCount = pageCount;
        this.pageSize = size;
    }
}
