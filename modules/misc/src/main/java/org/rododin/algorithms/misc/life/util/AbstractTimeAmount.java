package org.rododin.algorithms.misc.life.util;

/**
 * Introduces a generic partial implementation of {@link TimeAmount}.
 */
public abstract class AbstractTimeAmount <Amount>
	implements TimeAmount <Amount>
{
	private final TimeUnit unit;

	protected AbstractTimeAmount(TimeUnit unit)
	{
		this.unit = unit;
	}

	public TimeUnit getUnit()
	{
		return unit;
	}

	@Override
	public String toString()
	{
		return getAmount() + getUnit().getAcronym();
	}
}
