package com.libmss.service;

import com.libmss.model.Analyze;
import com.libmss.model.ResponseModel;

public interface AnalyzeService<T> {

    public ResponseModel<Analyze> borrowNum(int type,T t);


}
