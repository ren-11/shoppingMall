package com.xzy.model;

import java.io.Serializable;

public class ShopUser implements Serializable {
    private Integer shopuserId;

    private Integer userId;

    private Integer shopId;

    private static final long serialVersionUID = 1L;

    public Integer getShopuserId() {
        return shopuserId;
    }

    public void setShopuserId(Integer shopuserId) {
        this.shopuserId = shopuserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}