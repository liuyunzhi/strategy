package com.demo.strategy.domain.order.service.strategy;

import reactor.core.publisher.Mono;

public interface PaymentStrategy {

    Mono<String> pay(String orderId);
}
