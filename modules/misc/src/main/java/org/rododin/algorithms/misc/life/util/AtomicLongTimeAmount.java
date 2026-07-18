package org.rododin.algorithms.misc.life.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Represents a {@link Long}-based implementation of {@link TimeAmount}.
 */
public class AtomicLongTimeAmount
	extends AbstractTimeAmount<Long>
{
	private final AtomicLong amount;

	public AtomicLongTimeAmount(TimeUnit unit)
	{
		this(0L, unit);
	}

	public AtomicLongTimeAmount(long amount, TimeUnit unit)
	{
		super(unit);
		this.amount = new AtomicLong(amount);
	}

	@Override
	public Long getAmount()
	{
		return amount.get();
	}

	@Override
	public void setAmount(Long newAmount)
	{
		amount.set(newAmount);
	}

	@Override
	public boolean compareAndSetAmount(Long expectedAmount, Long newAmount)
	{
		return amount.compareAndSet(expectedAmount, newAmount);
	}

	@Override
	public Long incrementAndGetAmount()
	{
		return amount.incrementAndGet();
	}

	@Override
	public Long decrementAndGetAmount()
	{
		return amount.decrementAndGet();
	}

	@Override
	public Long addAndGetAmount(Long deltaAmount)
	{
		return amount.addAndGet(deltaAmount);
	}
}
