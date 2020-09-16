package org.rododin.algorithms.misc.chess;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a game.
 *
 * @author Nikolay Chebotaryov
 */
public class Game
{
	private final Long gameId;
	private final List<Player> players;

	public Game(Long gameId, Player white, Player black)
	{
		this.gameId = gameId;
		this.players = Arrays.asList(white, black);
	}

	public Long getGameId()
	{
		return gameId;
	}

	public List<Player> getPlayers()
	{
		return players;
	}
}
