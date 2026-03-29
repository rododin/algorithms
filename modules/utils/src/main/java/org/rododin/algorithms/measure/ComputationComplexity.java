package org.rododin.algorithms.measure;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;

import org.rododin.algorithms.structures.Pair;
import org.rododin.algorithms.utils.MathX;

/**
 * Enumerates the traditional and some extra algorithm computation complexity classes.
 * <p>Additionally, it provides the {@link #estimate(long, long)} method for rough estimation of the
 * {@link ComputationComplexity} class on the top of given {@code n} and {@code itCount} in the case of a single execution
 * of an algorithm.
 * <p>Finally, it also provides the {@link #estimateO(List)} and {@link #estimateO(List, boolean)} methods for more
 * precised (but still rough) estimation of the {@link ComputationComplexity} class in cases of multiple algorithm
 * executions on different data sets.
 *
 * @author Nikolay Chebotaryov
 */
public enum ComputationComplexity
{
	/** {@code O(1)} */
	O_1          ((n, itCount) -> itCount <= 1, "O(1)"),
	/** <code>O(log<sub>2</sub>n)</code> */
	O_LogN       ((n, itCount) -> itCount <= MathX.log2(n), "O(log₂n)"),
	/** {@code O(n/2)} */
	O_Ndiv2      ((n, itCount) -> itCount <= n / 2, "O(n/2)"),
	/** {@code O(n)} */
	O_N          ((n, itCount) -> itCount <= n, "O(n)"),
	/** {@code O(2×n)} */
	O_Nx2        ((n, itCount) -> itCount <= 2 * n, "O(2×n)"),
	/** <code>O(n×log<sub>2</sub>n)</code> */
	O_NxLogN     ((n, itCount) -> itCount <= n * (MathX.log2(n)), "O(n×log₂n)"),
	/** <code>O(n<sup>2</sup>/2)</code> */
	O_Npow2div2  ((n, itCount) -> itCount <= Math.pow(n, 2) / 2, "O(n²/2)"),
	/** <code>O(n<sup>2</sup>)</code> */
	O_Npow2      ((n, itCount) -> itCount <= Math.pow(n, 2), "O(n²)"),
	/** <code>O(2×n<sup>2</sup>)</code> */
	O_Npow2x2    ((n, itCount) -> itCount <= Math.pow(n, 2) * 2, "O(2×n²)"),
	/** <code>O(n<sup>2</sup>×log<sub>2</sub>n)</code> */
	O_Npow2xLogN ((n, itCount) -> itCount <= Math.pow(n, 2) * (MathX.log2(n)), "O(n²×log₂n)"),
	/** <code>O(n<sup>3</sup>)</code> */
	O_Npow3      ((n, itCount) -> itCount <= Math.pow(n, 3), "O(n³)"),
	/** <code>O(n<sup>3</sup>×log<sub>2</sub>n)</code> */
	O_Npow3xLogN ((n, itCount) -> itCount <= Math.pow(n, 3) * (MathX.log2(n)), "O(n³×log₂n)"),
	/** <code>O(n<sup>4</sup>)</code> */
	O_Npow4      ((n, itCount) -> itCount <= Math.pow(n, 4), "O(n⁴)"),
	/** <code>O(2<sup>n</sup>)</code> */
	O_2powN      ((n, itCount) -> itCount <= Math.pow(2, n), "O(2ⁿ)"),
	/** {@code O(n!)} */
	O_Nfact((n, itCount) -> BigInteger.valueOf(itCount).compareTo(MathX.fact(n)) <= 0, "O(n!)"),
	/** <code>O(n<sup>n</sup>)</code> */
	O_NpowN      ((n, itCount) -> itCount <= Math.pow(n, n), "O(nⁿ)"),
	/** Over {@code O(n!)} */
	O_NpowNover((n, itCount) -> true, "> O(nⁿ)");

	ComputationComplexity(BiFunction<Long, Long, Boolean> estimator, String string)
	{
		this.estimator = estimator;
		this.string = string;
	}

	/**
	 * Estimates the {@link ComputationComplexity} class of a single execution of an algorithm on the top of given
	 * {@code n} and {@code itCount} values.
	 *
	 * @param n Zero or positive number of the elements handled by an algorithm, i.e. it's {@code n} of the {@code O(n)} function.
	 * @param itCount The real number of iterations executed by the algorithm on handling the {@code n} elements,
	 *                i.e. it's the numeric (integer) value of the {@code O(n)} function.
	 *
	 * @return The estimated non-{@code null} {@link ComputationComplexity} class.
	 *
	 * @see #estimateO(List)
	 * @see #estimateO(List, boolean)
	 */
	public static ComputationComplexity estimate(long n, long itCount)
	{
		for (ComputationComplexity complexity : values())
		{
			if (complexity.estimator.apply(n, itCount))
				return complexity;
		}
		throw new RuntimeException("Internal error"); // impossible case, because the estimator for O_NfacOver returns always true
	}

	/**
	 * Estimates the {@link ComputationComplexity} class on the top of multiple executions of an algorithm.
	 * Generally it returns the worst estimation (aka {@code Big O}) made by the {@link #estimate(long, long)} method for each of the {@code itCounts} entries.
	 * The implementation just calls to {@link #estimateO(List, boolean) estimate(itCounts, false)}.
	 * @param itCounts The list of pairs where each entry represents a mapping of {@code n} to {@code itCount} for the algorithm execution case, where:
	 *                 <ul>
	 *                   <li>{@code n} is a zero or positive number of the elements handled by an algorithm, i.e. it's {@code n} of the {@code O(n)} function for the algorithm execution case.</li>
	 *                   <li>{@code itCount} is the real number of iterations executed by the algorithm on handling the {@code n} elements, i.e. it's the numeric (integer) value of the {@code O(n)} function.</li>
	 *                 </ul>
	 * @return The estimated non-{@code null} {@link ComputationComplexity} class.
	 */
	public static ComputationComplexity estimateO(List<Pair<Long, Long>> itCounts)
	{
		return estimateO(itCounts, false);
	}

	/**
	 * Estimates the {@link ComputationComplexity} class on the top of multiple executions of an algorithm.
	 * Generally it returns the worst estimation (aka {@code Big O}) made by the {@link #estimate(long, long)} method for each of the {@code itCounts} entries.
	 * However, if {@code forced_O_1} is {@code true}, it may return {@link #O_1 O(1)} forcibly if there are different {@code n}s in {@code itCounts},
	 * but all mapped {@code itCount} values are the same.
	 *
	 * @param itCounts The list of pairs where each entry represents a mapping of {@code n} to {@code itCount} for the algorithm execution case, where:
	 *                 <ul>
	 *                   <li>{@code n} is a zero or positive number of the elements handled by an algorithm, i.e. it's {@code n} of the {@code O(n)} function for the algorithm execution case.</li>
	 *                   <li>{@code itCount} is the real number of iterations executed by the algorithm on handling the {@code n} elements, i.e. it's the numeric (integer) value of the {@code O(n)} function.</li>
	 *                 </ul>
	 * @param forced_O_1 {@code true} to force the {@link #O_1 O(1)} result in case of same estimations on different number of
	 *                   handled elements
	 *
	 * @return The estimated non-{@code null} {@link ComputationComplexity} class.
	 *
	 * @see #estimateO(List)
	 * @see #estimate(long, long)
	 */
	public static ComputationComplexity estimateO(List<Pair<Long, Long>> itCounts, boolean forced_O_1)
	{
		ComputationComplexity worstComplexity = null;
		Long lastN = null;
		Long lastItCount = null;
		boolean differentNs = false;
		boolean differentItCounts = false;
		for (Pair<Long, Long> itCountEntry : itCounts)
		{
			if (lastN == null)
				lastN = itCountEntry.getFirst();
			else if (!lastN.equals(itCountEntry.getFirst()))
				differentNs = true;

			if (lastItCount == null)
				lastItCount = itCountEntry.getSecond();
			else if (!lastItCount.equals(itCountEntry.getSecond()))
				differentItCounts = true;

			final ComputationComplexity complexity = estimate(itCountEntry.getFirst(), itCountEntry.getSecond());
			if (worstComplexity == null || worstComplexity.ordinal() < complexity.ordinal())
				worstComplexity = complexity;
		}
		return (forced_O_1 && differentNs && !differentItCounts) ? O_1 : worstComplexity;
	}

	/**
	 * Estimates the best {@link ComputationComplexity} class (aka {code Ω(n)} – "omega-of-n") on the top of multiple executions of an algorithm.
	 * I.e. it returns the best estimation made by the {@link #estimate(long, long)} method for each of the {@code itCounts} entries.
	 *
	 * @param itCounts The list of pairs where each entry represents a mapping of {@code n} to {@code itCount} for the algorithm execution case, where:
	 *                 <ul>
	 *                   <li>{@code n} is a zero or positive number of the elements handled by an algorithm, i.e. it's {@code n} of the {@code O(n)} function for the algorithm execution case.</li>
	 *                   <li>{@code itCount} is the real number of iterations executed by the algorithm on handling the {@code n} elements, i.e. it's the numeric (integer) value of the {@code O(n)} function.</li>
	 *                 </ul>
	 *
	 * @return The estimated non-{@code null} {@link ComputationComplexity} class.
	 *
	 */
	public static ComputationComplexity estimateΩ(List<Pair<Long, Long>> itCounts)
	{
		ComputationComplexity bestComplexity = null;
		for (Pair<Long, Long> itCountEntry : itCounts)
		{
			final ComputationComplexity complexity = estimate(itCountEntry.getFirst(), itCountEntry.getSecond());
			if (bestComplexity == null || bestComplexity.ordinal() > complexity.ordinal())
				bestComplexity = complexity;
		}
		return bestComplexity;
	}

	@Override
	public String toString()
	{
		return string;
	}

	private final BiFunction<Long, Long, Boolean> estimator;
	private final String string;
}
