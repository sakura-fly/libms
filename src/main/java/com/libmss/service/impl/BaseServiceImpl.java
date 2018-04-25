package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.service.BaseService;
import com.libmss.util.StringValue;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    BaseDao<T> dao;

    public BaseServiceImpl() {
    }

    public BaseServiceImpl(BaseDao<T> dao) {
        this.dao = dao;
    }

    protected abstract void setDao() ;

    @Override
    public ResponseModel<T> add(T t) {
        int stat = dao.add(t);
        ResponseModel<T> rm = new ResponseModel<T>();
        rm.setCode(stat);
        rm.setMsg(stat == 0 ? StringValue.RESPONSE_SUCCES : StringValue.RESPONSE_FAILD);
        return rm;
    }

    @Override
    public ResponseModel<T> update(T t) {
        ResponseModel<T> rm = new ResponseModel<T>();
        int stat = dao.update(t);
        rm.setCode(stat);
        rm.setMsg(stat == 0 ? StringValue.RESPONSE_SUCCES : StringValue.RESPONSE_FAILD);
        return rm;
    }

    @Override
    public ResponseModel<T> list(PageModel page, T t) {
        ResponseModel<T> rm = new ResponseModel<T>();
        List<T> lsit = dao.list(page, t);
        rm.setMsg(lsit.isEmpty() ? StringValue.LIST_FAILD : "");
        rm.setCode(lsit.isEmpty() ? -1 : 0);
        rm.setData(lsit);
        rm.setCount(dao.count(t));
        return rm;
    }
}
