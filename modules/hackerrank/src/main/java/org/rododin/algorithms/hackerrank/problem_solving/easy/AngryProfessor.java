package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/angry-professor/problem">
 *   Practice > Algorithms > Implementation > Angry Professor
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AngryProfessor
{
	/**
	 * Determines whether the professor's class is cancelled or not.
	 * The complexity is: <code>O(n)</code>, where <code>n</code> is the {@code times.size()}.
	 *
	 * @param threshold the minimal number of students to be arrived on time to get the class continued,
	 *                  where {@code 0 ≤ threshold ≤ times.size()}
	 * @param times     the student arrival times, where {@code time[i] <= 0} means the student arrived on time,
	 *                  where {@code time[i]} is any possible {@code int} number and {@code 0 ≤ times.size()}
	 * @return          {@code "YES"} if the class is cancelled, {@code "NO"} otherwise
	 */
	public static String isClassCancelled(int threshold, int[] times)
	{
		int onTimeCount = 0;
		for(int time : times)
		{
			if (time <= 0)
			{
				onTimeCount++;
				if (onTimeCount >= threshold)
					return "NO";
			}
		}
		return onTimeCount >= threshold ? "NO" : "YES";
	}
}
