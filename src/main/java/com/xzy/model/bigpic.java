package com.xzy.model;

import java.io.Serializable;

public class bigpic implements Serializable {
    private Integer bigpicId;

    private Integer goodsId;

    private String bigpic;

    private static final long serialVersionUID = 1L;

    public Integer getBigpicId() {
        return bigpicId;
    }

    public void setBigpicId(Integer bigpicId) {
        this.bigpicId = bigpicId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getBigpic() {
        return bigpic;
    }

    public void setBigpic(String bigpic) {
        this.bigpic = bigpic;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}