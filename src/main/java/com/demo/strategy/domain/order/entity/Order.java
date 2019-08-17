package com.demo.strategy.domain.order.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Order {
    private String id;
    private OrderType orderType;

    private Order(final String id, final OrderType orderType) {
        this.id = id;
        this.orderType = orderType;
    }

    public static Order create(OrderType orderType) {
        return new Order(UUID.randomUUID().toString(), orderType);
    }
}
