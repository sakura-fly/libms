package com.libmss.dao;

import com.libmss.model.Analyze;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnalyzeDao {

    public List<Analyze> borrowNum(String tName, int uid);

}
