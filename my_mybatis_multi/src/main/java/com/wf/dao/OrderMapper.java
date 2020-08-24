package com.wf.dao;

import com.wf.domain.Order;

import java.util.List;

public interface OrderMapper {
    public List<Order> findAll();
}
