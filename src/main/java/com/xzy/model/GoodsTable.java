package com.xzy.model;

import java.io.Serializable;

public class GoodsTable implements Serializable {
    private Integer goodsId;

    private Integer sGid;

    private String goodsName;

    private Float goodsPrice;

    private String goodsPic;

    private String goodsDes;

    private Integer goodsCom;

    private Integer firstId;

    private Integer secondId;

    private static final long serialVersionUID = 1L;

    public Integer getsGid() { return sGid; }

    public void setsGid(Integer sGid) { this.sGid = sGid; }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes == null ? null : goodsDes.trim();
    }

    public Integer getGoodsCom() {
        return goodsCom;
    }

    public void setGoodsCom(Integer goodsCom) {
        this.goodsCom = goodsCom;
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public Integer getSecondId() {
        return secondId;
    }

    public void setSecondId(Integer secondId) {
        this.secondId = secondId;
    }
}