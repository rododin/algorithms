package org.rododin.algorithms.misc.java_internals_uncovered;

import java.util.Locale;

/**
 * Implements some arithmetic examples to show the bit depth overflow.
 */
public class ArithmeticExperiments
{
	public static final Locale NUM_LOCALE = Locale.forLanguageTag("de-CH"); // Apostrophe-based thousands separator

	public static void someBitDepthOverflowCornerCases()
	{
		System.out.println("Arithmetic overflow on addition:");
		int i = 2_000_000_000;
		int j = 1_000_000_000;
		int sumIJ = i + j;
		System.out.printf(NUM_LOCALE, "Integers:     %,14d + %,d = %,d\n", i, j, sumIJ);

		long minI = Integer.MIN_VALUE;
		long l = 3_000_000_000L;
		long sum2MinIL = 2 * minI + l;
		System.out.printf(NUM_LOCALE, "Longs   : 2 * %,14d + %,d = %,d\n", minI, l, sum2MinIL);

		System.out.println();
		System.out.println("Arithmetic overflow on product:");

		int n = 2 * i;
		System.out.printf(NUM_LOCALE, "Integers:         %,14d * %,d = %,14d\n", 2, i, n);

		long sumMinIM = 2 * minI + 2 * (long)i;
		System.out.printf(NUM_LOCALE, "Longs   : 2 * %,d + 2 * %,d = %,14d\n", minI, i, sumMinIM);

		System.out.println();
	}

	public static void rightShiftAnalysis()
	{
		int n0 = 0xFFFFFFFF; // -1
		int n1 = n0 >> 4;
		int n2 = n0 >>> 2;

		System.out.println("0xFFFFFFFF >>  4 = " + n1);
		System.out.println("0xFFFFFFFF >>> 2 = " + n2);

		int p = Integer.MAX_VALUE;
		p <<= 1;

		System.out.println("0x7FFFFFFF << 1 = " + p);

		System.out.println();

		int bitField = 0x00000000;
		System.out.printf("DECIMAL: %10d, HEXADECIMAL: %08X, BINARY: %32s\n", bitField, bitField, Integer.toBinaryString(bitField));
		bitField = 0xFFFFFFFF;
		System.out.printf("DECIMAL: %10d, HEXADECIMAL: %08X, BINARY: %32s\n", bitField, bitField, Integer.toBinaryString(bitField));
		bitField >>= 1;
		System.out.printf("DECIMAL: %10d, HEXADECIMAL: %08X, BINARY: %32s\n", bitField, bitField, Integer.toBinaryString(bitField));
		bitField >>>= 1;
		System.out.printf("DECIMAL: %10d, HEXADECIMAL: %08X, BINARY: %32s\n", bitField, bitField, Integer.toBinaryString(bitField));

		System.out.printf("DECIMAL: %10d, HEXADECIMAL: %08X, BINARY: %32s\n", n2, n2, Integer.toBinaryString(n2));
		System.out.printf("DECIMAL: %10d, HEXADECIMAL: %08X, BINARY: %32s\n", p, p, Integer.toBinaryString(p));
	}

}
