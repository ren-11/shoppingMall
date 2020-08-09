package com.xzy.vo;

import com.xzy.model.Seller;

import java.util.ArrayList;
import java.util.List;

//封装发现页面vo对象
public class Findsvo {
    //封装用户收藏商家
    private List<Seller> sellers;
    //封装商家推送
    private List<Findsellergoods> findsellergoods;

    public List<Findsellergoods> getFindsellergoods() {
        return findsellergoods;
    }

    public void setFindsellergoods(List<Findsellergoods> findsellergoods) {
        this.findsellergoods = findsellergoods;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Findsvo{" +
                "sellers=" + sellers +
                ", findsellergoods=" + findsellergoods +
                '}';
    }
}
