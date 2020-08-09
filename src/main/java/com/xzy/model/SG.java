package com.xzy.model;

import java.io.Serializable;

public class SG implements Serializable {
    private Integer sGid;

    private Integer goodsId;

    private Integer sellerId;

    private Integer stuck;

    private Integer success;

    private static final long serialVersionUID = 1L;

    public Integer getsGid() {
        return sGid;
    }

    public void setsGid(Integer sGid) {
        this.sGid = sGid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getStuck() {
        return stuck;
    }

    public void setStuck(Integer stuck) {
        this.stuck = stuck;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }
}