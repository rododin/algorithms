package org.rododin.algorithms.misc;

import java.util.concurrent.atomic.AtomicReference;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.misc.java_internals_uncovered.ArithmeticExperiments;
import org.rododin.algorithms.misc.java_internals_uncovered.CollectionExperiments;
import org.rododin.algorithms.misc.java_internals_uncovered.ObjectSizeAnalysis;

/**
 * Just an app stub for quick testing.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Misc
	implements Constants
{
	public static void main(String[] args)
	{
		ArithmeticExperiments.someBitDepthOverflowCornerCases();
		ArithmeticExperiments.rightShiftAnalysis();

		System.out.println();
		CollectionExperiments.checkForNulls();

		System.out.println();
		ObjectSizeAnalysis.objectSizeAnalysis();
	}

	final static AtomicReference<UserId> userIdRef = new AtomicReference<>();

	public static void atomics()
	{
		final AtomicReference<UserId> userIdAtomicReference = new AtomicReference<>();
	}

	public static UserId getUserId()
	{
		return userIdRef.updateAndGet(old -> old == null ? new UserId(0, "") : old);
	}
}
