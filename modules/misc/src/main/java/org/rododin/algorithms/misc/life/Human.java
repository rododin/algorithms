package org.rododin.algorithms.misc.life;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.rododin.algorithms.misc.life.util.AtomicLongTimeAmount;
import org.rododin.algorithms.misc.life.util.TimeUnit;

/**
 * Represents a human entity.
 */
public abstract class Human
	<Spouse extends Human<?>>
{
	public static final TimeUnit AGE_TIME_UNIT = TimeUnit.Month;
	public static final Long MIN_REPRODUCTION_AGE = 16L * 12L;
	public static final Long MAX_REPRODUCTION_AGE = 45L * 12L;
	private final AtomicLongTimeAmount age = new AtomicLongTimeAmount(0L, AGE_TIME_UNIT);
	private final AtomicReference<Man> father = new AtomicReference<>();
	private final AtomicReference<Woman> mother = new AtomicReference<>();
	private final AtomicReference<Spouse> spouse = new AtomicReference<>();
	private final List<Human<?>> children = new CopyOnWriteArrayList<>();
	private final AtomicBoolean died = new AtomicBoolean();

	protected Human()
	{
		this (0L);
	}

	protected Human(long age)
	{
		this (age, null, null);
	}

	protected Human(Man father, Woman mother)
	{
		this (0L, father, mother);
	}

	protected Human(long age, Man father, Woman mother)
	{
		this.age.setAmount(age);
		this.father.set(father);
		this.mother.set(mother);
	}

	public long getAge()
	{
		return age.getAmount();
	}

	public long incrementAndGetAge()
	{
		return age.incrementAndGetAmount();
	}

	public long addAndGetAge(long deltaAge)
	{
		return age.addAndGetAmount(deltaAge);
	}

	public boolean isReadyForReproduction()
	{
		final long age = getAge();
		return age >= MIN_REPRODUCTION_AGE && age <= MAX_REPRODUCTION_AGE;
	}

	public Man getFather()
	{
		return father.get();
	}

	public Woman getMother()
	{
		return mother.get();
	}

	public Spouse getSpouse()
	{
		return spouse.get();
	}

	public boolean setSpouse(Spouse spouse)
	{
		return this.spouse.compareAndSet(null, spouse);
	}

	public boolean isMarried()
	{
		return getSpouse() != null;
	}

	public List<Human<?>> getChildren()
	{
		return Collections.unmodifiableList(children);
	}

	public void addChild(Human<?> child)
	{
		this.children.add(child);
	}

	public boolean isDied()
	{
		return died.get();
	}

	public void setDied()
	{
		died.set(true);
	}

	@Override
	public String toString()
	{
		return getClass().getSimpleName()
		     + "{age=" + getAge()
		     + ", married=" + isMarried()
		     + ", childrenCount=" + getChildren().size()
		     + ", died=" + isDied()
		     + '}';
	}
}
