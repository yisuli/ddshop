package com.lys.ddshop.common.dto;

import java.util.List;

/**
 * User: Administrator
 * Date: 2017/11/7
 * Time: 20:07
 * Version:V1.0
 */
public class Result<T> {
private int total;
private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
