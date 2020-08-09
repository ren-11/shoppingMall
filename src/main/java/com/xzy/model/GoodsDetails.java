package com.xzy.model;

import java.io.Serializable;

public class GoodsDetails implements Serializable {
    private Integer detailsId;

    private Integer comId;

    private Integer colId;

    private Integer sGid;

    private static final long serialVersionUID = 1L;

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public Integer getsGid() {
        return sGid;
    }

    public void setsGid(Integer sGid) {
        this.sGid = sGid;
    }
}