package com.demo.strategy.domain.order.service.strategy.payment;

import com.demo.strategy.domain.order.service.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class NormalOrderPayment implements PaymentStrategy {

    @Override
    public Mono<String> pay(final String orderId) {
        return Mono.justOrEmpty("Pay normal order: " + orderId);
    }
}
