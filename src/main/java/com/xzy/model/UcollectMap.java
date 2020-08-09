package com.xzy.model;

public class UcollectMap {
    private int scol_ID;
    private String seller_name;
    private String seller_pic;

    public String getSeller_pic() {
        return seller_pic;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public int getScol_ID() {
        return scol_ID;
    }

    public void setSeller_pic(String seller_pic) {
        this.seller_pic = seller_pic;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public void setScol_ID(int scol_ID) {
        this.scol_ID = scol_ID;
    }
}
