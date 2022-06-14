package com.hlw.noteservice.model;

import java.io.Serializable;
import java.util.List;

public class PageResp<T> implements Serializable {
    private Integer page;
    private Integer pageSize;
    private List<T> data;
    private Long total;

    public PageResp(PageRequest request, List<T> data, Long total) {
        this.page = request.getPage();
        this.pageSize = request.getPageSize();
        this.data = data;
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
