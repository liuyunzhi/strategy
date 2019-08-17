package com.demo.strategy.domain.order.service.strategy.payment;

import com.demo.strategy.domain.order.entity.OrderType;
import com.demo.strategy.domain.order.service.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class PaymentStrategyContext {

    private final Map<OrderType, PaymentStrategy> strategies;

    @Autowired
    public PaymentStrategyContext(final NormalOrderPayment normalOrderPayment,
                                  final PromotionOrderPayment promotionOrderPayment) {
        strategies = new EnumMap<>(OrderType.class);
        strategies.put(OrderType.NORMAL, normalOrderPayment);
        strategies.put(OrderType.PROMOTION, promotionOrderPayment);
    }

    public PaymentStrategy of(OrderType orderType) {
        return strategies.get(orderType);
    }
}
