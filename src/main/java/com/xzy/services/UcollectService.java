package com.xzy.services;

import com.xzy.model.PageDiv;
import com.xzy.model.USCollect;
import com.xzy.model.UcollectMap;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface UcollectService {
    public List<UcollectMap> ulist(int userId);
    public void udelete(USCollect uscollect);
    public PageDiv<UcollectMap> pagelist(HttpServletRequest request);
}
