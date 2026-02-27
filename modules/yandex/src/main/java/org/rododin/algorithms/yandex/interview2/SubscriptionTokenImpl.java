package org.rododin.algorithms.yandex.interview2;

import java.util.UUID;

/**
 * TODO: Add description.
 */
public class SubscriptionTokenImpl
	implements SubscriptionToken
{
	private UUID uuid;

	public SubscriptionTokenImpl()
	{
		this (UUID.randomUUID());
	}

	public SubscriptionTokenImpl(UUID uuid)
	{
		this.uuid = uuid;
	}

	@Override
	public final boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof final SubscriptionTokenImpl that))
			return false;

		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode()
	{
		return uuid.hashCode();
	}
}
