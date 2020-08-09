package com.xzy.services;

import com.xzy.model.Collect;
import com.xzy.model.CollectMap;
import com.xzy.model.PageDiv;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CollectService {
    public List<CollectMap> list(int userId);
    //增
    public void add(Collect collect);
    //删
    public void delete(Collect collect);
    public PageDiv<CollectMap> pagelist(HttpServletRequest request);
}
