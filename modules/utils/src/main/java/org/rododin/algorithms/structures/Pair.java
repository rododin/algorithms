package org.rododin.algorithms.structures;

import org.rododin.algorithms.structures.impl.StandardPair;

/**
 * Introduces the pair concept implementation.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public interface Pair <First, Second>
{
	static <F, S> Pair<F, S> of (F first, S second)
	{
		return new StandardPair<>(first, second);
	}

	First getFirst();
	void setFirst(First first);

	Second getSecond();
	void setSecond(Second second);
}
