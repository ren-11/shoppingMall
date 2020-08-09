package com.xzy.model;

public class CollectMap {
    private int col_ID;
    private int col_num;
    private String goods_name;
    private String goods_pic;
    private String goods_des;
    public String getGoods_pic() {
        return goods_pic;
    }
    public String getGoods_name() {
        return goods_name;
    }
    public String getGoods_des() {
        return goods_des;
    }
    public int getCol_num() {
        return col_num;
    }
    public int getCol_ID() {
        return col_ID;
    }
    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    public void setGoods_des(String goods_des) {
        this.goods_des = goods_des;
    }

    public void setCol_num(int col_num) {
        this.col_num = col_num;
    }

    public void setCol_ID(int col_ID) {
        this.col_ID = col_ID;
    }
}
