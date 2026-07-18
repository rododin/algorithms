package org.rododin.algorithms.misc.life;

import org.rododin.algorithms.misc.life.util.AtomicLongTimeAmount;

/**
 * Represents a woman extending the {@link Man} entity.
 */
public class Woman
	extends Human<Man>
{
	public static final Long PREGNANCY_PERIOD = 9L; // Months
	public static final Long FEEDING_PERIOD = 12L; // Months
	private final AtomicLongTimeAmount pregnancyAge = new AtomicLongTimeAmount(AGE_TIME_UNIT);
	private final AtomicLongTimeAmount feedingAge = new AtomicLongTimeAmount(AGE_TIME_UNIT);

	public Woman()
	{
	}

	public Woman(long age)
	{
		super(age);
	}

	public Woman(Man father, Woman mother)
	{
		super(father, mother);
	}

	public Woman(long age, Man father, Woman mother)
	{
		super(age, father, mother);
	}

	public long getPregnancyAge()
	{
		return pregnancyAge.getAmount();
	}

	public void setPregnancyAge(long newPregnancyAge)
	{
		pregnancyAge.setAmount(newPregnancyAge);
	}

	public boolean isPregnant()
	{
		final long pregnancyAge = getPregnancyAge();
		return pregnancyAge > 0 && pregnancyAge <= PREGNANCY_PERIOD;
	}

	public long incrementAndGetPregnancyAge()
	{
		return pregnancyAge.incrementAndGetAmount();
	}

	public long getFeedingAge()
	{
		return feedingAge.getAmount();
	}

	public void setFeedingAge(long newFeedingAge)
	{
		feedingAge.setAmount(newFeedingAge);
	}

	public long incrementAndGetFeedingAge()
	{
		return feedingAge.incrementAndGetAmount();
	}

	public boolean isFeeding()
	{
		final long feedingAge = getFeedingAge();
		return feedingAge > 0 && feedingAge <= FEEDING_PERIOD;
	}

}
