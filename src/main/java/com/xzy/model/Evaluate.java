package com.xzy.model;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    private Integer comId;

    private Integer userId;

    private Integer goodsId;

    private String dialogbox;

    private Integer comNum;

    private Date date;

    private static final long serialVersionUID = 1L;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getDialogbox() {
        return dialogbox;
    }

    public void setDialogbox(String dialogbox) {
        this.dialogbox = dialogbox == null ? null : dialogbox.trim();
    }

    public Integer getComNum() {
        return comNum;
    }

    public void setComNum(Integer comNum) {
        this.comNum = comNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}