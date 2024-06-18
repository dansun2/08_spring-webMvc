package com.ohgiraffers.chap07thymeleaf.model.dto;

import lombok.*;


public class SelectCriteria {
    @Override
    public String toString() {
        return "SelectCriteria{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", pageNo=" + pageNo +
                '}';
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    private int startPage;
    private int endPage;
    private int pageNo;

    public SelectCriteria(int startPage, int endPage, int pageNo) {
        this.startPage = startPage;
        this.endPage = endPage;
        this.pageNo = pageNo;
    }
}
