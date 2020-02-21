/*
 * CatsAndMouse.java
 */

package org.rododin.algorithms.hackerrank.easy;

/**
 * <a href="https://www.hackerrank.com/challenges/cats-and-a-mouse/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Cats and a Mouse
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CatsAndMouse
{
	public static String printCatAndMouse(int catA, int catB, int mouseC)
	{
		final String rv = catAndMouse(catA, catB, mouseC);
		System.out.println("catA=" + catA + ", catB=" + catB + ", mouseC=" + mouseC + " -> " + rv);
		return rv;
	}

	public static String catAndMouse(int catA, int catB, int mouseC)
	{
		final int ac = Math.abs(catA - mouseC);
		final int bc = Math.abs(catB - mouseC);
		return ac == bc ? "Mouse C" :
		       ac <  bc ? "Cat A"   :
		                  "Cat B"   ;
	}
}
