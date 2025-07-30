package org.rododin.algorithms.hackerrank.java.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-comparator/problem">
 *   HackerRank >Prepare > Java > Data Structures > Java Comparator
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaComparator
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();

		final Player[] players = new Player[n];
		final Checker<Player> checker = new Checker<>();

		for (int i = 0; i < n; i++)
			players[i] = new Player(scanner.next(), scanner.nextInt());

		scanner.close();

		Arrays.sort(players, checker);

		for (final Player player : players)
			System.out.printf("%s %s\n", player.name, player.score);
	}
}

class Player
{
	String name;
	int score;

	Player(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
}

class Checker <P extends Player>
	implements Comparator<P>
{
	@Override
	public int compare(P player1, P player2)
	{
		final int scoreDiff = player2.score - player1.score;
		if (scoreDiff != 0)
			return scoreDiff;

		return player1.name.compareTo(player2.name);
	}
}
