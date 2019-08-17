package com.demo.strategy.domain.order.service.strategy.payment;

import com.demo.strategy.domain.order.entity.Order;
import com.demo.strategy.domain.order.service.strategy.payment.PromotionOrderPayment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(MockitoJUnitRunner.class)
public class PromotionOrderPaymentTest {

    @InjectMocks
    private PromotionOrderPayment promotionOrderStrategy;

    @Test
    public void should_pay_promotion_order() {
        final String orderId = "1";

        Mono<String> mono = promotionOrderStrategy.pay(orderId);

        StepVerifier.create(mono)
                .expectNext("Pay promotion order: 1")
                .verifyComplete();
    }
}