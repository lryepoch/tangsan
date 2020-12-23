package com.simple.qa.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private int currentPage;
    private int pageSize;
    private int total;
    private List<T> recordList;

    private int pageNum;

    public Page() {
        this(1, 3, 0, new ArrayList());
    }

    public Page(int currentPage, int pageSize) {
        this(currentPage, pageSize, 0, new ArrayList());
    }

    public Page(int currentPage, int pageSize, int total, List<T> recordList) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage<1){
            currentPage=1;
            return;
        }
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize<=0){
            pageSize=1;
            return;
        }
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNum() {
        if (total<=0){
            pageNum=1;
            return pageNum;
        }
        if (total%pageSize==0){
            pageNum=(int)(total/pageSize);
        } else{
            pageSize=(int)(total/pageSize+1);
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<T> recordList) {
        this.recordList = recordList;
    }

}
