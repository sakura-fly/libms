package com.libmss.dao.impl;

import com.libmss.dao.AnalyzeDao;
import com.libmss.model.Analyze;
import com.libmss.util.IntValue;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AnalyzeDaoimpl<T> implements AnalyzeDao<T> {


    private Map<Integer, Set<String>> tm = new HashMap<>();

    private Set<String> as = new HashSet<>();
    private Set<String> ts = new HashSet<>();
    private Set<String> ps = new HashSet<>();
    private Set<String> ns = new HashSet<>();


    {

        ps.add("清华大学出版社");
        ps.add("机械工业出版社");
        ps.add("电子工业");
        ps.add("中国致公出版社");
        ps.add("黑龙江出版社");

        as.add("江南");
        as.add("娑罗双树");
        as.add("双子星罗");
        as.add("树下野狐");
        as.add("玄色");

        ts.add("文学作品");
        ts.add("工具书");
        ts.add("教育相关");

        ns.add("格言");
        ns.add("读者");
        ns.add("意林");
        ns.add("计算机工程与设计");
        tm.put(IntValue.AUTH, as);
        tm.put(IntValue.TYPE, ts);
        tm.put(IntValue.PUBRISHER, ps);
        tm.put(IntValue.NAME, ns);
    }

    @Override
    public List<Analyze> borrowNum(int type, T t) {
//        Analyze analyze = new Analyze();
        List<Analyze> list = new ArrayList<>();
        Set<String> ty = tm.get(type);
        for (String tt : ty) {
            list.add(new Analyze(tt, (int) (Math.random() * 100)));
        }
        // list.add(new Analyze(tm.get(type),22));
        return list;

    }
}
