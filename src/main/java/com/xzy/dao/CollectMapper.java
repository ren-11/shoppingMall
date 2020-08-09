package com.xzy.dao;

import com.xzy.model.Collect;
import com.xzy.model.CollectMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    public List<CollectMap> list(int userId);
    //增加
    public void add(Collect collect);
    //删除
    public void delete(Collect collect);
    public List<CollectMap> pagelist(@Param(value = "start") Integer start, @Param(value = "pageSize") Integer pageSize);
    public int getCount();
}
