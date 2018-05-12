package com.libmss.util;

import org.hibernate.SQLQuery;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SqlUtil {

    public static String sqlFindLike(Object t) {
        StringBuilder s = new StringBuilder();
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        for (Field f : uf) {
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("double") || type.endsWith("Double") || type.endsWith("float") || type.endsWith("Float")) {
                    if (((Number) val).intValue() != -2233) {
                        s.append(" and ").append(name).append(" like :").append(name);
                    }
                } else {
                    if (val != null && !val.toString().isEmpty()) {
                        s.append(" and ").append(name).append(" like :").append(name);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return s.toString();
    }


    public static String sqlFindIs(Object t) {
        StringBuffer s = new StringBuffer();
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        for (Field f : uf) {
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("double") || type.endsWith("Double") || type.endsWith("float") || type.endsWith("Float")) {
                    if (((Number) val).intValue() != -2233) {
                        s.append(" and ").append(name).append(" = :").append(name);
                    }
                } else {
                    if (val != null && !val.toString().isEmpty()) {
                        s.append(" and ").append(name).append(" = :").append(name);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return s.toString();
    }

    public static String sqlUpdateSet(Object t) {
        StringBuffer s = new StringBuffer();
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        for (Field f : uf) {
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("double") || type.endsWith("Double") || type.endsWith("float") || type.endsWith("Float")) {
                    if (((Number) val).intValue() != -2233) {
                        s.append(" , ").append(name).append(" = :").append(name);
                    }
                } else {
                    if (val != null && !val.toString().isEmpty()) {
                        s.append(" , ").append(name).append(" = :").append(name);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return s.toString();
    }

    public static SQLQuery createSqlLike(Object t, SQLQuery sql) {
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        for (Field f : uf) {
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("double") || type.endsWith("Double") || type.endsWith("float") || type.endsWith("Float")) {
                    if (((Number) val).intValue() != -2233) {
                        sql.setParameter(name, "%" + val + "%");
                    }
                } else {
                    if (val != null && !val.toString().isEmpty()) {
                        sql.setParameter(name, "%" + val + "%");
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return sql;
    }

    public static SQLQuery createSqlIs(Object t, SQLQuery sql) {
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        for (Field f : uf) {
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith("int") || type.endsWith("Integer") || type.endsWith("double") || type.endsWith("Double") || type.endsWith("float") || type.endsWith("Float")) {
                    if (((Number) val).intValue() != -2233) {
                        // selectSql.append(" and " + name + " = :" + name);
                        sql.setParameter(name, val);
                    }
                } else {
                    if (val != null && !val.toString().isEmpty()) {
                        sql.setParameter(name, val);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sql;
    }

}
