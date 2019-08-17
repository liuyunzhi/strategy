package com.demo.strategy.domain.order.service;

import com.demo.strategy.domain.order.entity.Order;
import com.demo.strategy.domain.order.entity.OrderType;
import com.demo.strategy.domain.order.service.strategy.payment.NormalOrderPayment;
import com.demo.strategy.domain.order.service.strategy.payment.PaymentStrategyContext;
import com.demo.strategy.domain.order.service.strategy.payment.PromotionOrderPayment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentStrategyContext paymentStrategyContext;

    @Test
    public void should_return_normal_order_payment_giving_a_normal_order() {
        OrderType normal = OrderType.NORMAL;
        given(paymentStrategyContext.of(normal))
                .willReturn(new NormalOrderPayment());

        Mono<String> mono = paymentService.pay(Order.create(normal));

        StepVerifier.create(mono, 1)
                .assertNext(actual -> assertThat(actual).isGreaterThan("Pay normal order: "))
                .verifyComplete();
    }

    @Test
    public void should_return_promotion_order_payment_giving_a_promotion_order() {
        OrderType promotion = OrderType.PROMOTION;
        given(paymentStrategyContext.of(promotion))
                .willReturn(new PromotionOrderPayment());

        Mono<String> mono = paymentService.pay(Order.create(promotion));

        StepVerifier.create(mono, 1)
                .assertNext(actual -> assertThat(actual).isGreaterThan("Pay promotion order: "))
                .verifyComplete();
    }
}