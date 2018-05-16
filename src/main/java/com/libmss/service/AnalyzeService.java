package com.libmss.service;

import com.libmss.model.Analyze;
import com.libmss.model.ResponseModel;

public interface AnalyzeService {

    public ResponseModel<Analyze> borrowNum(String  tName, int uid);


}
