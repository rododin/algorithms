package org.rododin.algorithms.yandex.interview2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Реализуйте простую pub-sub систему для обмена событиями между компонентами с возможностью отписки через токены.
 *
 * Требования:
 * - Подписка на события должна возвращать уникальный токен
 * - Отписка происходит по токену
 * - События должны доставляться асинхронно
 * - Система должна быть потокобезопасной.
 *
 * Версия 2, реализованная после собеседования, полагаю - возможная.
 *
 * @see EventBusImpl1
 */
public class EventBusImpl2
	implements EventBus
{
	private final ConcurrentHashMap<SubscriptionToken, Consumer<OrderCreated>> subscriptions
		= new ConcurrentHashMap<>();

	final ExecutorService executor = Executors.newScheduledThreadPool(10);

	@Override
	public SubscriptionToken subscribe(Consumer<OrderCreated> handler)
	{
		final SubscriptionToken subscriptionToken = new SubscriptionTokenImpl();
		subscriptions.put(subscriptionToken, handler);
		return subscriptionToken;
	}

	@Override
	public void unsubscribe(SubscriptionToken token)
	{
		if (subscriptions.remove(token) == null)
			throw new RuntimeException("No such subscription");
	}

	@Override
	public void publish(OrderCreated event)
	{
		try
		{
			// Полагаю, верное решение.
			subscriptions.values().forEach(s -> executor.submit(() -> s.accept(event)));
		}
		catch (Exception x)
		{
			System.out.println("Asynchronous task submission error: " + x);
		}
	}

	/**
	 * Этот метод рекомендуется вызывать явно для остановки EventBus-сервиса
	 */
	public void shutdown()
	{
		executor.shutdown();
	}
}