package com.demo.strategy.domain.order.service;

import com.demo.strategy.domain.order.entity.Order;
import com.demo.strategy.domain.order.service.strategy.payment.PaymentStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {

    private final PaymentStrategyContext paymentStrategyContext;

    @Autowired
    public PaymentService(PaymentStrategyContext paymentStrategyContext) {
        this.paymentStrategyContext = paymentStrategyContext;
    }

    public Mono<String> pay(Order order) {
        return paymentStrategyContext
                .of(order.getOrderType())
                .pay(order.getId());
    }
}
