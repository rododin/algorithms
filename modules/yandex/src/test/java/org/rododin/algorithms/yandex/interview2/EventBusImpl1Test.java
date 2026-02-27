package org.rododin.algorithms.yandex.interview2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit Test(s) for <code>{@link EventBusImpl1}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class EventBusImpl1Test
{
	@Test
	public void testEventDeliveryWithToken() throws InterruptedException
	{
		EventBus eventBus = new EventBusImpl1();

		AtomicInteger orderCount = new AtomicInteger();
		AtomicReference<String> lastOrderId = new AtomicReference<>();

		SubscriptionToken token = eventBus.subscribe(order -> {
			orderCount.incrementAndGet();
			lastOrderId.set(order.orderId);
		});

		eventBus.publish(new OrderCreated("ORDER-123"));
		Thread.sleep(100);

		Assertions.assertEquals(1, orderCount.get());
		Assertions.assertEquals("ORDER-123", lastOrderId.get());
	}

	@Test
	public void test100ClientsAnd1000Orders()
		throws InterruptedException
	{
		EventBus eventBus = new EventBusImpl1();

		ConcurrentHashMap<SubscriptionToken, List<OrderCreated>> handledOrders = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++)
		{
			AtomicReference<OrderCreated> ref = new AtomicReference<>();
			final AtomicReference<SubscriptionToken> tokenRef = new AtomicReference<>();
			tokenRef.set(eventBus.subscribe(order -> handledOrders.compute(tokenRef.get(), (t, bucket) -> (bucket == null ? new ArrayList<>() : bucket)).add(ref.get())));
			System.out.println("Client " + i + ", order=" + ref.get());
		}

		for (int i = 0; i < 1000; i++)
		{
			eventBus.publish(new OrderCreated(Integer.toString(i)));
		}

		// TODO: Instead of sleep, do some awaiting, e.g. based on CountDownLatch
		Thread.sleep(100);

		Assertions.assertEquals(100, handledOrders.size());
		handledOrders.forEach((token, bucket) -> Assertions.assertEquals(1000, bucket.size()));
	}
}
