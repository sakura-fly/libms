package com.libmss.service.impl;

import com.libmss.dao.AnalyzeDao;
import com.libmss.model.Analyze;
import com.libmss.model.ResponseModel;
import com.libmss.service.AnalyzeService;
import com.libmss.util.StringValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyzeServiceImpl<T> implements AnalyzeService<T> {

    private AnalyzeDao<T> analyzeDao;

    public AnalyzeServiceImpl(AnalyzeDao<T> analyzeDao) {
        this.analyzeDao = analyzeDao;
    }

    @Override
    public ResponseModel<Analyze> borrowNum(int type,T t) {
        ResponseModel<Analyze> r = new ResponseModel<>();
        List<Analyze> l = analyzeDao.borrowNum(type, t);
        r.setData(l);
        r.setMsg(l == null || l.isEmpty() ? StringValue.LIST_FAILD : "");
        r.setCode(l == null || l.isEmpty() ? -1 : 0);
        return r;
    }
}
