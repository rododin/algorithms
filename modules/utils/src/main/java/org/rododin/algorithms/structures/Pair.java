/*
 * Pair.java
 */

package org.rododin.algorithms.structures;

import org.rododin.algorithms.structures.impl.StandardPair;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public interface Pair <First, Second>
{
	First getFirst();
	void setFirst(First first);

	Second getSecond();
	void setSecond(Second second);

	static <F, S> Pair<F, S> of(F first, S second)
	{
		return new StandardPair(first, second);
	}
}
