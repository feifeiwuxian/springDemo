package com.wf.dao;

public interface AccountDao {
    public void out(String outMan, double money);
    public void in(String outMan, double money);
}
