package cn.connxun.morui.entity;

import java.util.List;

/**
 * Created by wushange on 2017/8/16.
 */

public class ListBean<T> {
    private int            total;
    private List<T> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
