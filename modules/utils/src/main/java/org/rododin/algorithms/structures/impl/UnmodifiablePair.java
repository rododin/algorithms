/*
 * UnmodifiablePair.java
 */

package org.rododin.algorithms.structures.impl;

import org.rododin.algorithms.structures.Pair;

/**
 * Description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public final class UnmodifiablePair <First, Second>
	extends AbstractPair<First, Second>
	implements Pair<First, Second>
{
	private final First  first;
	private final Second second;

	public UnmodifiablePair(final First first, final Second second)
	{
		this.first = first;
		this.second = second;
	}

	public First getFirst()
	{
		return first;
	}

	public void setFirst(final First first)
	{
		throw new UnsupportedOperationException();
	}

	public Second getSecond()
	{
		return second;
	}

	public void setSecond(final Second second)
	{
		throw new UnsupportedOperationException();
	}
}
