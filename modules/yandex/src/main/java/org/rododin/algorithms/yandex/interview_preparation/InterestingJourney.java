package org.rododin.algorithms.yandex.interview_preparation;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1><a href="https://contest.yandex.ru/contest/8458/problems/G/">Интересное путешествие</a></h1>
 * <p>
 * Не секрет, что некоторые программисты очень любят путешествовать.
 * Хорошо всем известный программист Петя тоже очень любит путешествовать,
 * посещать музеи и осматривать достопримечательности других городов.
 * <p>
 * Для перемещений между из города в город он предпочитает использовать машину.
 * При этом он заправляется только на станциях в городах, но не на станциях по пути.
 * Поэтому он очень аккуратно выбирает маршруты, чтобы машина не заглохла в дороге.
 * А ещё Петя очень важный член команды, поэтому он не может себе позволить путешествовать слишком долго.
 * Он решил написать программу, которая поможет ему с выбором очередного путешествия.
 * Но так как сейчас у него слишком много других задач, он попросил вас помочь ему.
 * <p>
 * Расстояние между двумя городами считается как сумма модулей разности по каждой из координат.
 * Дороги есть между всеми парами городов.
 * <p>
 * <h2>Формат ввода</h2>
 * В первой строке входных данных записано количество городов {@code n} ({@code 2 ≤ n ≤ 1000}).
 * В следующих {@code n} строках даны два целых числа: координаты каждого города, не превосходящие по модулю миллиарда.
 * Все города пронумерованы числами от {@code 1} до {@code n} в порядке записи во входных данных.
 * <p>
 * В следующей строке записано целое положительное число {@code k}, не превосходящее двух миллиардов,
 * — максимальное расстояние между городами, которое Петя может преодолеть без дозаправки машины.
 * <p>
 * В последней строке записаны два различных числа — номер города, откуда едет Петя, и номер города, куда он едет.
 * <h2>Формат вывода</h2>
 * Если существуют пути, удовлетворяющие описанным выше условиям, то выведите минимальное количество дорог,
 * которое нужно проехать, чтобы попасть из начальной точки маршрута в конечную.
 * Если пути не существует, выведите {@code -1}.
 * <p>
 * <h2>Пример 1</h2>
 * <h3>Ввод</h3>
 * <pre>
 * 7
 * 0 0
 * 0 2
 * 2 2
 * 0 -2
 * 2 -2
 * 2 -1
 * 2 1
 * 2
 * 1 3
 * </pre>
 * <h3>Вывод</h3>
 * <pre>
 * 2
 * </pre>
 * <p>
 * <h2>Пример 2</h2>
 * <h3>Ввод</h3>
 * <pre>
 * 4
 * 0 0
 * 1 0
 * 0 1
 * 1 1
 * 2
 * 1 4
 * </pre>
 * <h3>Вывод</h3>
 * <pre>
 * 1
 * </pre>
 * <h2>Пример 3</h2>
 * <h3>Ввод</h3>
 * <pre>
 * 4
 * 0 0
 * 2 0
 * 0 2
 * 2 2
 * 1
 * 1 4
 * </pre>
 * <h3>Вывод</h3>
 * <pre>
 * -1
 * </pre>
 * <h2>Моё решение</h2>
 * Для чтения ввода можем использовать {@link Scanner}, для записи вывода — тривиальный
 * {@link PrintStream#println System.out.println()}.
 * <p>
 * Здесь я пробовал несколько решений.
 * <p>
 * Первое решение, основанное на рекурсивном поиске в глубину, не давало правильного результата, позволяя находить
 * путь, но не всегда самый короткий.
 * <p>
 * Второе решение, основанное на поиске в ширину (волновой поиск), позволило решить задачу правильно, пройти все тесты.
 * Полагаю, данное решение является правильным и одним из наиболее оптимальных.
 * <p>
 * Первая реализация этого решения (волнового поиска в ширину) была у меня рекурсивной, и основанной на использовании
 * {@link HashMap} с созданием копии ещё не пройденных узлов (городов). Это решение прошло все тесты,
 * и было удовлетворительным по времени, но, очевидно, не было максимально-оптимальным.
 * <p>
 * Поэтому я реализовал улучшенную версию данного решения, без использования рекурсии и без создания копии непройденных
 * узлов/городов, однако с удалением достигнутых на каждой волне.
 * <p>
 * <b>Сложность</b>: В наихудшем случае мы, очевидно, имеем <code>O(n<sup>2</sup>)</code>, если нам из первого города
 * нужно достигнуть последний, последовательно пройдя через все остальные, т.е. достигая лишь один город на каждой волне,
 * и достигая заданного лишь на последней (либо не достигая вовсе).
 * <h2>Иные возможные решения</h2>
 * Очевидно, что данную задачу также можно было бы решить, используя
 * <a href="https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm">Алгоритм Дейкстры</a>, но мне его описание показалось
 * более "мутным"/непонятным, в сравнении с простым интуитивно-понятным принципом распространения волны в ширину,
 * равно как не особо понятным осталось и его ограничение насчёт рёбер отрицательного веса.
 */
public class InterestingJourney
{
	/**
	 * Нерабочая версия программы, с чтением городов в список, и поиском в глубину, позволяющая находить путь, но
	 * не всегда оптимальный/кратчайший.
	 *
	 * @see #main(String[])
	 */
	public static void main0(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		List<City> cities = new ArrayList<>();
		for (int i = 0; i < n; i++)
			cities.add(new City(sc.nextInt(), sc.nextInt()));

		int k = sc.nextInt();
		int from = sc.nextInt() - 1;
		int to = sc.nextInt() - 1;

		System.out.println(findMinPathLength(cities, from, to, k));
	}

	/**
	 * Рекурсивна реализация поиска в глубину (нерабочая), позволяющая находить путь, но не всегда оптимальный/кратчайший.
	 *
	 * @see #findMinPath(Map, City, City, int)
	 * @see #findMinPath2(Map, int, int, int)
	 */
	static int findMinPathLength(List<City> cities, int from, int to, int k)
	{
		if (distance(cities, from, to) <= k)
			return 1;

		final int next = findNextCity(cities, from, to, k);
		if (next == from)
			return -1;
		else
		{
			final int l = findMinPathLength(cities, next, to, k);
			return l != -1 ? l + 1 : -1;
		}
	}

	static int findNextCity(List<City> cities, int from, int to, int k)
	{
		int next = from;
		long minDistanceTo = Long.MAX_VALUE;
		for (int i = 0; i < cities.size(); i++)
		{
			if (i != from && i != to)
			{
				final long dFrom = distance(cities, from, i);
				final long dTo = distance(cities, i, to);
				if (dFrom <= k && dTo < minDistanceTo)
				{
					minDistanceTo = dTo;
					next = i;
				}
			}
		}
		return next;
	}

	/**
	 * Рабочая версия программы, использующая чтение городов в карту и дальнейший поиск в ширину (волновой поиск).
	 */
	public static void main(String[] args)
	{
		final Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();

		// Читаем города в карту, мапим (отображаем) их на их индексы.
		// Почему мы используем карту - смотреть ниже, в описании реализации алгоритма.
		final Map<Integer, City> cities = new HashMap<>(n * 3 / 4 + 1);
		for (int i = 0; i < n; i++)
			cities.put(i, new City(sc.nextInt(), sc.nextInt()));

		final int k = sc.nextInt();

		// Города у нас проиндексированы начиная с 0, в то время как по заданию (на вводе/во входном файле) - с 1,
		// поэтому считанные индексы from и to уменьшаем на 1
		final int from = sc.nextInt() - 1;
		final int to = sc.nextInt() - 1;

		final int minPath = findMinPath2(cities, from, to, k);

		System.out.println(minPath);
	}

	/**
	 * Первая рабочая/успешная версия алгоритма волнового поиска (поиска в ширину), рекурсивная.
	 * На каждой рекурсии создаётся копия карты с ещё недостигнутыми городами, что приводит к неоптимальному
	 * использованию памяти и создаёт дополнительную вычислительную нагрузку.
	 * Но данная версия алгоритма несколько более проста с точки зрения реализации, в сравнении с последующей, более
	 * оптимальной версией ({@link #findMinPath2(Map, int, int, int)}).
	 * <p><b>NOTE:</b> почему используются карты, смотреть в описании {@link #findMinPath2(Map, int, int, int)}.
	 */
	private static int findMinPath(Map<Integer, City> cities, City cityFrom, City cityTo, int k)
	{
		// Проверяем, достижим ли город сразу, и если да, то возвращаем 1, что означает, достижим за 1 шаг (за одну волну)
		long d = distance(cityFrom, cityTo);
		if (d <= k)
			return 1;

		// Определяем города, достижимые на текущей волне.
		final Map<Integer, City> reachedCities = new HashMap<>();
		final Iterator<Map.Entry<Integer, City>> citiesIterator = cities.entrySet().iterator();
		while (citiesIterator.hasNext())
		{
			final Map.Entry<Integer, City> entry = citiesIterator.next();
			d = distance(cityFrom, entry.getValue());
			if (d <= k)
			{
				reachedCities.put(entry.getKey(), entry.getValue());
				// Достигнутые города удаляем из карты ещё недостигнутых городов
				citiesIterator.remove();
			}
		}

		int minPath = Integer.MAX_VALUE;
		// Для всех городов, достигнутых на данной волне, запускаем рекурсию (последующие волны)
		for (Map.Entry<Integer, City> entry : reachedCities.entrySet())
		{
			// Для рекурсии нам нужно создать отдельную копию ещё недостигнутых городов, иначе мы можем не найти оптимальный (кратчайший) путь
			final int path = findMinPath(new HashMap<>(cities), entry.getValue(), cityTo, k);
			if (path > 0 && minPath > path)
				minPath = path;
		}

		return minPath == Integer.MAX_VALUE ? -1 : minPath + 1;
	}

	/**
	 * Финальная, нерекурсивная и наиболее оптимальная версия алгоритма, реализующего волновой поиск в ширину.
	 * <p><b>NOTE:</b> Мы используем карты, в которых города отображены на их изначальные индексы, т.к. нам нужно сохранять
	 * и работать с изначальными индексами, при том, что мы удаляем достигнутые города из изначальной карты/контейнера.
	 * Если бы мы использовали списки/массивы, это было бы накладно при удалении
	 * (вызов {@link System#arraycopy(Object, int, Object, int, int)} на каждом удалении), и после уже одного такого
	 * удаления мы бы не смогли бы использовать изначальные индексы, т.е. значения {@code from} и {@code to} стали бы
	 * неактуальными.
	 */
	private static int findMinPath2(Map<Integer, City> cities, int from, int to, int k)
	{
		// Карта городов, которые достигнуты на данной волне.
		// Исключаем авто-расширение карты, задавая максимальную возможную ёмкость с учётом стандартного loadFactor-а = 0.75
		Map<Integer, City> lastReachedCities = new HashMap<>(cities.size() * 4 / 3 + 1);
		// Изначально принимаем достигнутым стартовый город
		lastReachedCities.put(from, cities.remove(from));
		boolean targetReached = false;
		// Начальная длина пути равна 1
		int currentPathLength = 1;
		// Внешний цикл распространения волны, т.е. крутим внешний цикл пока у нас есть города, достигнутые на предыдущих волнах.
		while (!lastReachedCities.isEmpty())
		{
			final Map<Integer, City> currentReachedCities = new HashMap<>();
			// Следующий цикл бежит по самим городам, достигнутым на предыдущей волне
			for (Map.Entry<Integer, City> lastReachedEntry : lastReachedCities.entrySet())
			{
				final City lastReachedCity = lastReachedEntry.getValue();
				// Самый внутренний цикл пробегает по ещё недостигнутым городам, определяя города, достижимые из текущего города, достигнутого на предыдущей волне
				for (Map.Entry<Integer, City> entry : cities.entrySet())
				{
					final int index = entry.getKey();
					final City city = entry.getValue();
					if (distance(lastReachedCity, city) <= k)
					{
						// Достигнув цели, заканчиваем спектакль
						// (можно было бы использовать break по метке, аналог goto, вместо последующей серии break-ов по условию)
						if (index == to)
						{
							targetReached = true;
							break;
						}
						// Иначе, если цели ещё не достигли, добавляем город в карту ныне-достигнутых городов
						currentReachedCities.put(index, city);
					}
				}
				if (targetReached)
					break;
			}
			if (targetReached)
				break;
			lastReachedCities = currentReachedCities;
			// Удаляем из изначальной карты все города, достигнутые на данной волне, исключая их из анализа на последующих волнах
			for (Integer lastReachedIndex : lastReachedCities.keySet())
				cities.remove(lastReachedIndex);
			// Переходя к следующей волне, увеличиваем длину пути на 1
			// (фактически, по заданию, нам нужно посчитать количество волн, которые надо распространить для достижения заданного города)
			currentPathLength++;
		}

		return targetReached ? currentPathLength : -1;
	}

	/**
	 * Упрощенное представление города, содержащее его координаты.
	 */
	private static class City
	{
		final long x;
		final long y;

		public City(long x, long y)
		{
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Вычисляет Манхэттенское расстояние между двумя данными городами.
	 */
	private static long distance(City from, City to)
	{
		return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
	}

	/**
	 * Вычисляет Манхэттенское расстояние между двумя городами, которые определяются заданными индексами/ключами
	 * {@code from} и {@code to} в заданной карте {@code cities}.
	 */
	private static long distance(Map<Integer, City> cities, int from, int to)
	{
		return distance(cities.get(from), cities.get(to));
	}

	/**
	 * Вычисляет Манхэттенское расстояние между двумя городами, которые определяются заданными индексами
	 * {@code from} и {@code to} в заданном списке {@code cities}.
	 */
	private static long distance(List<City> cities, int from, int to)
	{
		return distance(cities.get(from), cities.get(to));
	}
}
