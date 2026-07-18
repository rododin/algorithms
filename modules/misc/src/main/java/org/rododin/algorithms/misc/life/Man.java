package org.rododin.algorithms.misc.life;

/**
 * Represents a man extending the {@link Human} entity.
 */
public class Man
	extends Human<Woman>
{
	public Man()
	{
	}

	public Man(long age)
	{
		super(age);
	}

	public Man(Man father, Woman mother)
	{
		super(father, mother);
	}

	public Man(long age, Man father, Woman mother)
	{
		super(age, father, mother);
	}
}
