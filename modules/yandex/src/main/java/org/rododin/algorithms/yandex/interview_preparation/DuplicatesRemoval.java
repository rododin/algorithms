package org.rododin.algorithms.yandex.interview_preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * <h1><a href="https://contest.yandex.ru/contest/8458/problems/C/">Удаление дубликатов</a></h1>
 * <p>
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
 * Требуется удалить из него все повторения.
 * <p>
 * Желательно получить решение, которое не считывает входной файл целиком в память,
 * т.е., использует лишь константный объем памяти в процессе работы.
 * <p>
 * <h2>Формат ввода</h2>
 * Первая строка входного файла содержит единственное число {@code n}, {@code n ≤ 1000000}.
 * <p>
 * На следующих {@code n} строках расположены числа — элементы массива, по одному на строку.
 * Числа отсортированы по неубыванию.
 * <p>
 * <h2>Формат вывода</h2>
 * Выходной файл должен содержать следующие в порядке возрастания уникальные элементы входного массива.
 * <p>
 * <h2>Пример 1</h2>
 * <h3>Ввод</h3>
 * <pre>
 * 5
 * 2
 * 4
 * 8
 * 8
 * 8
 * </pre>
 * <h3>Вывод</h3>
 * <pre>
 * 2
 * 4
 * 8
 * </pre>
 * <p>
 * <h2>Пример 2</h2>
 * <h3>Ввод</h3>
 * <pre>
 * 5
 * 2
 * 2
 * 2
 * 8
 * 8
 * </pre>
 * <h3>Вывод</h3>
 * <pre>
 * 2
 * 8
 * </pre>
 * <h2>Моё решение</h2>
 * Во-первых, здесь мы не можем использовать {@link Scanner} для чтения ввода, ибо он работает неприемлемо медленно и
 * не позволяет пройти авто-тесты Yandex-а по времени выполнения, поскольку иногда нам нужно читать очень большие
 * объёмы данных из {@code STDIN}. Поэтому, используем чтение с помощью {@link InputStreamReader} и буферизацией
 * посредством {@link BufferedReader}: {@code new BufferedReader(new InputStreamReader(System.in))}.
 * <p>
 * Само решение — довольно простое. Мы не читаем элементы в какой-либо буферный массив/список предварительно, а
 * обрабатываем их на лету, сразу по прочтении. Поскольку массив упорядочен, мы просто сверяем текущий элемент с
 * предыдущим, и если он не равен предыдущему, то мы его печатаем в {@code STDOUT}, иначе (если повторяется) —
 * просто пропускаем. Таким образом, мы всегда печатаем последний элемент из цепочки повторяющихся, поэтому в конце,
 * по завершении основного цикла, мы должны распечатать последний ещё ненапечатанный.
 * <p>
 * <b>Сложность</b>: линейная, т.е. {@code O(n)}, где {@code n} — количество элементов в исходном массиве.
 */
public class DuplicatesRemoval
{
	public static void main(String[] args)
	{
		try
		{
			final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(bf.readLine());
			int last = n-- > 0 ? Integer.parseInt(bf.readLine()) : Integer.MIN_VALUE;
			for (int i = 0; i < n; i++)
			{
				int v = Integer.parseInt(bf.readLine());
				if (v != last)
				{
					System.out.println(last);
					last = v;
				}
			}
			if (n >= 0)
				System.out.println(last);
		}
		catch (IOException x)
		{
			throw new RuntimeException(x);
		}
	}
}
