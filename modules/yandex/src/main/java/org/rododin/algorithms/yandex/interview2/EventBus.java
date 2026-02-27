package org.rododin.algorithms.yandex.interview2;

import java.util.function.Consumer;

/**
 * TODO: Add description.
 */
public interface EventBus
{
	SubscriptionToken subscribe(Consumer<OrderCreated> handler);
	void unsubscribe(SubscriptionToken token);
	void publish(OrderCreated event);
}
