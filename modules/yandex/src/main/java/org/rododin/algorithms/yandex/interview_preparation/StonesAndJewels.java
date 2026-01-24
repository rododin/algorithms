package org.rododin.algorithms.yandex.interview_preparation;

import java.util.HashSet;
import java.util.Scanner;

/**
 * <h1><a href="https://contest.yandex.ru/contest/8458/problems/A/">Камни и украшения</a></h1>
 * <p>
 * Даны две строки строчных латинских символов: строка {@code J} и строка {@code S}.
 * Символы, входящие в строку {@code J} — «драгоценности», входящие в строку {@code S} — «камни».
 * Нужно определить, какое количество символов из {@code S} одновременно являются «драгоценностями».
 * Проще говоря, нужно проверить, какое количество символов из {@code S} входит в {@code J}.
 * <p>
 * Это разминочная задача, к которой мы размещаем готовые решения.
 * Она очень простая и нужна для того, чтобы вы могли познакомиться с нашей автоматической системой проверки решений.
 * Ввод и вывод осуществляется через файлы, либо через стандартные потоки ввода-вывода, как вам удобнее.
 * <p>
 * <h2>Формат ввода</h2>
 * На двух первых строках входного файла содержатся две строки строчных латинских символов:
 * строка {@code J} и строка {@code S}.
 * Длина каждой не превосходит 100 символов.
 * <p>
 * <h2>Формат вывода</h2>
 * Выходной файл должен содержать единственное число — количество камней, являющихся драгоценностями.
 * <p>
 * <h2>Ограничения</h2>
 * <ul>
 *   <li>Ограничение времени: 1 секунда</li>
 *   <li>Ограничение памяти: 64 MB</li>
 *   <li>Ввод: стандартный ввод или <code>input.txt</code></li>
 *   <li>Вывод: стандартный вывод или <code>output.txt</code></li>
 * </ul>
 * <p>
 * <h2>Пример</h2>
 * <h3>Ввод</h3>
 * <pre>
 * ab
 * aabbccd
 * </pre>
 * <h3>Вывод</h3>
 * <pre>
 * 4
 * </pre>
 * <h2>Моё решение</h2>
 * Читаем символы из {@code J} во множество, затем проходим посимвольно {@code S} и проверяем, входит ли каждый символ
 * из {@code S} во множество, и если да, то увеличиваем счётчик.
 * <p>
 * <b>Сложность</b>: {@code O(m + n)}, где {@code m} и {@code n} — длины строк {@code J} и {@code S} соответственно.
 * <p>
 * <b>Замечание</b>: Сложность вставки и проверки элемента в множестве {@link HashSet} составляет условно {@code O(1)},
 *                   поэтому эти операции условно не влияют на вычислительную сложность алгоритма.
 */
public class StonesAndJewels
{
	public static void main(String[] args)
	{
		// Redirecting STDIN to Scanner, which allows to read from console easily
		final Scanner sc = new Scanner(System.in);

		// Reading the `J` and `S` strings
		final String j = sc.nextLine();
		final String s = sc.nextLine();

		// Adding all characters from `J` to a set
		final HashSet<Character> jSet = new HashSet<>(j.length() * 3 / 4 + 1);
		for (int i = 0; i < j.length(); i++)
			jSet.add(j.charAt(i));

		// Now checking whether each character from `S` also presents in `J` or not, and incrementing a counter if presents.
		int counter = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (jSet.contains(s.charAt(i)))
				counter++;
		}

		// Now printing the results
		System.out.println(counter);
	}
}
