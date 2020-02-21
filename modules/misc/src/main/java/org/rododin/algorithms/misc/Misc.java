package org.rododin.algorithms.misc;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.misc.magic_square_forming.MagicSquareForming;

/**
 * TODO: Add description.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Misc
	implements Constants
{
	public static void main(String[] args)
	{
		MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{5, 3, 4},
			{1, 5, 8},
			{6, 4, 2},
		});
		MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{4, 9, 2},
			{3, 5, 7},
			{8, 1, 5},
		});
		MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{4, 8, 2},
			{4, 5, 7},
			{6, 1, 6},
		});
		MagicSquareForming.printFormingMagicSquare(new int[][]
		{
			{1, 8, 9},
			{2, 5, 7},
			{3, 4, 9},
		});
	}
}
