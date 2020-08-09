package com.xzy.model;

import java.io.Serializable;

public class  USCollect implements Serializable {
    private Integer colId;

    private Integer userId;

    private Integer sellerId;

    private static final long serialVersionUID = 1L;

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}