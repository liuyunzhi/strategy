package com.demo.strategy.domain.order.service.strategy.payment;

import com.demo.strategy.domain.order.entity.OrderType;
import com.demo.strategy.domain.order.service.strategy.PaymentStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PaymentStrategyContextTest {

    @InjectMocks
    private PaymentStrategyContext paymentStrategyContext;

    @Mock
    private NormalOrderPayment normalOrderPayment;
    @Mock
    private PromotionOrderPayment promotionOrderPayment;

    @Test
    public void should_return_normal_order_payment_class_giving_normal_order_type() {

        final PaymentStrategy strategy = paymentStrategyContext.of(OrderType.NORMAL);

        assertThat(strategy).isInstanceOf(NormalOrderPayment.class);
    }

    @Test
    public void should_return_promotion_order_payment_class_giving_promotion_order_type() {

        final PaymentStrategy strategy = paymentStrategyContext.of(OrderType.NORMAL);

        assertThat(strategy).isInstanceOf(NormalOrderPayment.class);
    }
}