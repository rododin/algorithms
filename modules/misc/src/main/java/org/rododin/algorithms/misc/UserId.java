package org.rododin.algorithms.misc;

import java.util.Objects;
import java.util.UUID;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov
 */
public class UserId
{
	private final long id;
	private final UUID uuid;
	private final String name;

	public UserId(long id, String name)
	{
		this (id, UUID.randomUUID(), name);
	}

	public UserId(long id, UUID uuid, String name)
	{
		this.id = id;
		this.uuid = uuid;
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public UUID getUuid()
	{
		return uuid;
	}

	public String getName()
	{
		return name;
	}

	//@Override
	//public boolean equals(Object o)
	//{
	//	if (!(o instanceof final UserId userId))
	//		return false;
	//	return id == userId.id
	//	    && Objects.equals(uuid, userId.uuid)
	//	    && Objects.equals(name, userId.name);
	//}
	//
	//@Override
	//public int hashCode()
	//{
	//	return Objects.hash(id, uuid, name);
	//}

	@Override
	public final boolean equals(Object o)
	{
		if (!(o instanceof final UserId userId))
			return false;

		return id == userId.id && uuid.equals(userId.uuid) && Objects.equals(name, userId.name);
	}

	@Override
	public int hashCode()
	{
		int result = Long.hashCode(id);
		result = 31 * result + uuid.hashCode();
		result = 31 * result + Objects.hashCode(name);
		return result;
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName()
		     + "{id=" + getId()
		     + ", uuid=" + getUuid()
		     + ", name=" + getName()
		     + '}';
	}
}

