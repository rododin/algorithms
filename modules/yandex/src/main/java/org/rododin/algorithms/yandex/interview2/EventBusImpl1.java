package org.rododin.algorithms.yandex.interview2;

import java.util.concurrent.ConcurrentHashMap;
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
 * Версия 1, реализованная на собеседовании, неверная, т.к. решение не было асинхронным.
 *
 * @see EventBusImpl2
 */
public class EventBusImpl1
	implements EventBus
{
	private final ConcurrentHashMap<SubscriptionToken, Consumer<OrderCreated>> subscriptions
		= new ConcurrentHashMap<>();

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
		// Неверное решение, согласно фид-беку, не асинхронное
		// Действительно, parallelStream() хотя и позволяет параллельно отправлять нотификации,
		// но вся конструкция в целом - будет ждать, пока все параллельные задачи не завершаться.
		subscriptions.values().parallelStream().forEach(h -> h.accept(event));

		// Верным решением, полагаю, могло бы быть любое другое решение, в т.ч. ручной запуск потоков,
		// в т.ч. использование Executors API, и т.д. См. EventBusImpl2
	}
}
