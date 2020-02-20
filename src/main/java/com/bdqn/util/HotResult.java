package com.bdqn.util;

import com.bdqn.entity.Hotevents;

import java.util.List;

public class HotResult {
    private long total;
    private List<Hotevents> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Hotevents> getRows() {
        return rows;
    }

    public void setRows(List<Hotevents> rows) {
        this.rows = rows;
    }
}
