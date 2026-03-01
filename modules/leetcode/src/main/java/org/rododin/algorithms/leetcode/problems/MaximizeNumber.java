package org.rododin.algorithms.leetcode.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 Задача 2.
 Даны два строковых представления чисел A и B. Нужно максимизировать A, заменив в нём любую
 цифру на цифру из B. Каждую цифру B можно использовать только один раз.
 */
public class MaximizeNumber
{
	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		final String a = in.next();
		final String b = in.next();
		final char[] aArr = a.toCharArray();
		final char[] bArr = b.toCharArray();
		Arrays.sort(bArr); // max digits will be at the end
		int lastUsedDigitIndex = bArr.length - 1;
		for (int i = 0; i < aArr.length && lastUsedDigitIndex >= 0; i++)
		{
			if (aArr[i] < bArr[lastUsedDigitIndex])
			{
				aArr[i] = bArr[lastUsedDigitIndex];
				lastUsedDigitIndex--;
			}
		}
		System.out.println(new String(aArr));
	}
}
