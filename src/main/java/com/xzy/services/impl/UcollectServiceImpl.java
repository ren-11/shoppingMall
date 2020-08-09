package com.xzy.services.impl;


import com.xzy.dao.UcollectMapper;
import com.xzy.model.PageDiv;
import com.xzy.model.USCollect;
import com.xzy.model.UcollectMap;
import com.xzy.services.UcollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UcollectServiceImpl implements UcollectService {
    @Autowired
    UcollectMapper ucollectDao;
    @Override
    public List<UcollectMap> ulist(int userId) {
        return ucollectDao.ulist(userId);
    }

    @Override
    public void udelete(USCollect ucollect) {
        ucollectDao.udelete(ucollect);
    }

    @Override
    public PageDiv<UcollectMap> pagelist(HttpServletRequest request) {
        int pageSize=5;
        int pageNo=1;
        int totalCount=0;
        totalCount=ucollectDao.getCount();
        List<UcollectMap> list=ucollectDao.pagelist((pageNo-1)*pageSize,pageSize);
        PageDiv<UcollectMap> pd=new PageDiv<UcollectMap>(pageNo, pageSize, totalCount, list);
        return pd;
    }
}
