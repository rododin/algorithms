/*
 * StandardPair.java
 */

package org.rododin.algorithms.structures.impl;

import org.rododin.algorithms.structures.Pair;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StandardPair <First, Second>
	extends AbstractPair<First, Second>
	implements Pair<First, Second>
{
	private First  first;
	private Second second;

	public StandardPair()
	{
		this (null, null);
	}

	public StandardPair(final First first, final Second second)
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
		this.first = first;
	}

	public Second getSecond()
	{
		return second;
	}

	public void setSecond(final Second second)
	{
		this.second = second;
	}
}
