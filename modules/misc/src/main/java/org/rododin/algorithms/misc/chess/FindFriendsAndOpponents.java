package org.rododin.algorithms.misc.chess;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Introduces algorithms for searching all user friends who plays a game and all their opponents.
 * Note, each friend may play more than one game at a moment.
 *
 * @author Nikolay Chebotaryov
 */
public class FindFriendsAndOpponents
{
	private final Map<Long, Game> games;
	private final Map<String, Set<Long>> friendGameIds;

	/**
	 * @param games a set of games mapped by their {@link Game#getGameId() IDs}
	 * @param friendGameIds the friend game {@link Game#getGameId() IDs} mapped by friend usernames
	 */
	public FindFriendsAndOpponents(Map<Long, Game> games, Map<String, Set<Long>> friendGameIds)
	{
		this.games = games;
		this.friendGameIds = friendGameIds;
	}

	public Map<Long, Game> getGames()
	{
		return games;
	}

	public Map<String, Set<Long>> getFriendGameIds()
	{
		return friendGameIds;
	}

	public Collection<String> findFriendsAndOpponents1(String username)
	{
		return friendGameIds.get(username).stream().flatMap(id -> games.get(id).getPlayers().stream().map(Player::getUsername)).distinct().sorted().collect(Collectors.toList());
	}

	public Collection<String> findFriendsAndOpponents2(String username)
	{
		final TreeSet<String> usernames = new TreeSet<>();
		friendGameIds.get(username).forEach(id -> games.get(id).getPlayers().forEach(player -> usernames.add(player.getUsername())));
		return usernames;
	}
}
