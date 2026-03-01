package org.rododin.algorithms.leetcode.problems;

import java.util.List;
import java.util.Scanner;

/**
 Задача 1.
 Напишите функцию для решения следующей задачи:

 В офисе AtCoder есть один увлажнитель. В момент времени 0 в нем нет воды.
 Вы доливаете воду N раз. В i-й раз (1 ≤ i ≤ N) вы доливаете V_i литров в момент T_i.
 Гарантируется, что T_i < T_{i+1} для всех 1 ≤ i ≤ N−1.
 Увлажнитель протекает: пока в нем есть вода, её количество уменьшается со скоростью 1 литр за единицу времени.
 Требуется найти количество воды в увлажнителе сразу после того, как вы закончите долив в момент T_N.

 Данные подаются как многострочная строка (input_str):

 Первая строка: одно целое число N — количество доливов.
 Следующие N строк: по два целых числа T_i и V_i, разделённые пробелом.
 Гарантируется, что T_i строго возрастают.
 Функция должна вернуть строку с одним числом — количеством воды сразу после долива в момент T_N.

 Ваш код должен пройти следующие тесты:

 Тест 1
 Вход:
 4
 1 3
 3 1
 4 4
 7 1
 Выход:
 3

 Тест 2
 Вход:
 3
 1 8
 10 11
 21 5
 Выход:
 5

 Тест 3
 Вход:
 10
 2 1
 22 10
 26 17
 29 2
 45 20
 47 32
 72 12
 75 1
 81 31
 97 7
 Выход:
 57
 */
public class LeakingWaterHumidifier
{
	public static void main(String[] args)
	{
		final Scanner in = new Scanner(System.in);
		int lastAmount = 0;
		int lastTi = 0;
		int n = in.nextInt();
		for (int i = 0; i < n; i++)
		{
			final int ti = in.nextInt();
			final int vi = in.nextInt();

			// the remained amount at the moment of ti
			lastAmount = Math.max(0, lastAmount - (ti - lastTi)); // 1 liter per ti, we could write 1 * (ti - lastTi)
			lastTi = ti; // updating the latest ti
			lastAmount += vi; // updating the lastAmount one more time with the current income (water amount)
		}
		System.out.println(lastAmount);
	}
}
