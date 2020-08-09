package com.xzy.dao;

import com.xzy.model.USCollect;
import com.xzy.model.UcollectMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UcollectMapper {
    public List<UcollectMap> ulist(int userId);
    public void udelete(USCollect ucollect);
    public List<UcollectMap> pagelist(@Param(value = "start") Integer start, @Param(value = "pageSize") Integer pageSize);
    public int getCount();
}
