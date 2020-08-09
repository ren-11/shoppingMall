package com.xzy.services.impl;

import com.xzy.dao.CollectMapper;
import com.xzy.model.Collect;
import com.xzy.model.CollectMap;
import com.xzy.model.PageDiv;
import com.xzy.services.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectDao;
    @Override
    public  List<CollectMap> list(int userId){
        return collectDao.list(userId);
    }

    @Override
    public void add(Collect collect) {
        collectDao.add(collect);
    }
    @Override
    public void delete(Collect collect) {
        collectDao.delete(collect);
    }

    @Override
    public PageDiv<CollectMap> pagelist(HttpServletRequest request) {
        int pageSize=5;
        int pageNo=1;
        int totalCount=0;
        totalCount=collectDao.getCount();
        List<CollectMap> list=collectDao.pagelist((pageNo-1)*pageSize,pageSize);
        PageDiv<CollectMap> pd=new PageDiv<CollectMap>(pageNo, pageSize, totalCount, list);
        return pd;
    }
}
