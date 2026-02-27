package org.rododin.algorithms.yandex.interview2;

import java.util.Objects;

/**
 * TODO: Add description.
 */
public class OrderCreated
{
	final String orderId;

	OrderCreated(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public final boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof final OrderCreated that))
			return false;

		return Objects.equals(orderId, that.orderId);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(orderId);
	}
}
