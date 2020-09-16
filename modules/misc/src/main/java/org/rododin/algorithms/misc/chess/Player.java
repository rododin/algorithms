package org.rododin.algorithms.misc.chess;

/**
 * Represents a game player.
 *
 * @author Nikolay Chebotaryov
 */
public class Player
{
	private final String username;

	public Player(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}
}
