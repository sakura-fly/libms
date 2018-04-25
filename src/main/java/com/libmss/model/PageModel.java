package com.libmss.model;

public class PageModel {
    public int page = 1;
    public int limit = 10;
    public int skip = limit * (page - 1);

}
