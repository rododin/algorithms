package org.rododin.algorithms.misc.chess;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link FindFriendsAndOpponents}</code>.
 * @author Nikolay Chebotaryov
 */
public class FindFriendsAndOpponentsTest
{
	private final Map<Long, Game> games = new LinkedHashMap<>();
	private final Map<String, Set<Long>> friendGameIds = new LinkedHashMap<>();

	@Before
	public void setup()
	{
		games.put(1L, new Game(1L, new Player("A"), new Player("B")));
		games.put(2L, new Game(2L, new Player("C"), new Player("D")));
		games.put(3L, new Game(3L, new Player("E"), new Player("F")));
		games.put(4L, new Game(4L, new Player("G"), new Player("H")));
		games.put(5L, new Game(5L, new Player("I"), new Player("J")));
		games.put(6L, new Game(6L, new Player("K"), new Player("L")));
		games.put(7L, new Game(7L, new Player("J"), new Player("E")));

		friendGameIds.put("A", new LinkedHashSet<Long>(Arrays.asList(1L, 3L, 5L, 7L)));
	}

	@Test
	public void testFindFriendsAndOpponents1()
	{
		final Collection<String> friendsAndUsernames = new FindFriendsAndOpponents(games, friendGameIds).findFriendsAndOpponents1("A");
		System.out.println(friendsAndUsernames);
		MatcherAssert.assertThat(friendsAndUsernames, CoreMatchers.hasItems("A", "B", "E", "F", "I", "J"));
	}

	@Test
	public void testFindFriendsAndOpponents2()
	{
		final Collection<String> friendsAndUsernames = new FindFriendsAndOpponents(games, friendGameIds).findFriendsAndOpponents2("A");
		System.out.println(friendsAndUsernames);
		MatcherAssert.assertThat(friendsAndUsernames, CoreMatchers.hasItems("A", "B", "E", "F", "I", "J"));
	}
}
