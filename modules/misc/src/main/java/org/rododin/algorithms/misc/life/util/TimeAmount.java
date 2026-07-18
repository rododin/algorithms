package org.rododin.algorithms.misc.life.util;

import java.math.BigInteger;

/**
 * Represents amount of time in defined {@link TimeUnit}s.
 *
 * @param <Amount> the type used to keep the time amount, e.g. {@link Long} or {@link BigInteger}.
 */
public interface TimeAmount <Amount>
{
	TimeUnit getUnit();

	Amount getAmount();

	void setAmount(Amount newAmount);

	boolean compareAndSetAmount(Amount expectedAmount, Amount newAmount);

	Amount incrementAndGetAmount();

	Amount decrementAndGetAmount();

	Amount addAndGetAmount(Amount deltaAmount);
}
