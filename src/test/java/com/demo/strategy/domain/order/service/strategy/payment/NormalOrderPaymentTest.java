package com.demo.strategy.domain.order.service.strategy.payment;

import com.demo.strategy.domain.order.entity.Order;
import com.demo.strategy.domain.order.service.strategy.payment.NormalOrderPayment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(MockitoJUnitRunner.class)
public class NormalOrderPaymentTest {

    @InjectMocks
    private NormalOrderPayment normalOrderStrategy;

    @Test
    public void should_pay_normal_order() {
        final String orderId = "1";

        Mono<String> mono = normalOrderStrategy.pay(orderId);

        StepVerifier.create(mono)
                .expectNext("Pay normal order: 1")
                .verifyComplete();
    }
}