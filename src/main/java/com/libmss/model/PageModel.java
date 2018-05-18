package com.libmss.model;

public class PageModel {
    public int page = 1;
    public int limit = 10;
    public int skip = limit * (page - 1);

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSkip() {
        return limit * (page - 1);
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }
}
