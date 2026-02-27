package org.rododin.algorithms.yandex.interview1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <b>Банкомат</b>
 * <p>
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 * <p>
 * Другие валюты и номиналы должны легко добавляться разработчиками в будущем.
 * Многопоточные сценарии могут быть добавлены позже (например резервирование).
 * <p>
 * Версия 2, реализованная после интервью №1.
 * <p>
 * <b>Решение</b>
 * <p>
 * Типичный банкомат не работает в конкурентном режиме,
 * в него параллельно не загружают деньги несколько обслуживающих лиц,
 * из него не снимают деньги параллельно несколько клиентов,
 * обслуживание и снятие денег также не происходит параллельно,
 * поэтому мы вполне можем обойтись без высоко-производительных конкурентных и иных синхронных контейнеров,
 * использовать внутри простые потоко-небезопасные контейнеры,
 * но весь внешний доступ организовать посредством простого synchronized-механизма,
 * таким образом, тем не менее, 100%-обеспечивая консистентность данных.
 * А по скольку доступ к банкомату фактически не осуществляется в конкурентном режиме, но лишь последовательно,
 * инфляция монитора до состояния "fat" едва ли будет происходить,
 * т.к. монитор едва ли будет захватываться в конкурентном режиме.
 * Поэтому, synchronized-механизм является оптимальным и надёжным решением в данном случае.
 */
public class ATM2
{
	public static final Currency Rouble = new CurrencyImpl("Rouble");

	public enum Banknotes
	{
		Rouble5   (new BanknoteImpl(Rouble,    5)),
		Rouble10  (new BanknoteImpl(Rouble,   10)),
		Rouble50  (new BanknoteImpl(Rouble,   50)),
		Rouble100 (new BanknoteImpl(Rouble,  100)),
		Rouble200 (new BanknoteImpl(Rouble,  200)),
		Rouble500 (new BanknoteImpl(Rouble,  500)),
		Rouble1000(new BanknoteImpl(Rouble, 1000)),
		Rouble2000(new BanknoteImpl(Rouble, 2000)),
		Rouble5000(new BanknoteImpl(Rouble, 5000)),
		;

		Banknotes(Banknote banknote)
		{
			this.banknote = banknote;
		}

		public Banknote get()
		{
			return banknote;
		}

		private final Banknote banknote;
	}

	public interface Currency
	{
		String getName();
	}

	public static class CurrencyImpl
		implements Currency
	{
		private final String name;

		public CurrencyImpl(String name)
		{
			this.name = name;
		}

		@Override
		public String getName()
		{
			return name;
		}

		@Override
		public final boolean equals(Object o)
		{
			if (!(o instanceof final CurrencyImpl currency))
				return false;

			return name.equals(currency.name);
		}

		@Override
		public int hashCode()
		{
			return name.hashCode();
		}
	}

	public interface Banknote
	{
		Currency getCurrency();
		int getValue();
	}

	public static class BanknoteImpl
		implements Banknote
	{
		private final Currency currency;
		private final int value;

		public BanknoteImpl(Currency currency, int value)
		{
			this.currency = currency;
			this.value = value;
		}

		@Override
		public Currency getCurrency()
		{
			return currency;
		}

		@Override
		public int getValue()
		{
			return value;
		}

		@Override
		public final boolean equals(Object o)
		{
			if (!(o instanceof final BanknoteImpl banknote))
				return false;

			return value == banknote.value && currency.equals(banknote.currency);
		}

		@Override
		public int hashCode()
		{
			int result = currency.hashCode();
			result = 31 * result + value;
			return result;
		}
	}

	private Map<Currency, List<Banknote>> banknotes = new HashMap<>();
	private Map<Banknote, Integer> cache = new HashMap<>();

	public synchronized Map<Currency, List<Banknote>> getAvailableBanknotes()
	{
		return new HashMap<>(banknotes);
	}

	public synchronized Map<Banknote, Integer> getAvailableCache()
	{
		return new HashMap<>(cache);
	}

	public synchronized void init(Map<Banknote, Integer> banknotes)
	{
		if (banknotes == null)
			throw new NullPointerException("Banknotes expected");

		this.banknotes = new HashMap<>();
		this.cache = new HashMap<>();

		for (Map.Entry<Banknote, Integer> entry : banknotes.entrySet())
		{
			this.banknotes.compute(entry.getKey().getCurrency(), (c, bs) -> bs == null ? new LinkedList<>() : bs).add(entry.getKey());
			this.cache.put(entry.getKey(), entry.getValue());
		}

		for (List<Banknote> curBanknotes : this.banknotes.values())
			curBanknotes.sort((b1, b2) -> Integer.compare(b2.getValue(), b1.getValue())); // reversed order, from greater to lower
	}

	public synchronized Map<Banknote, Integer> withdraw(Currency currency, int amount)
	{
		if (currency == null)
			throw new NullPointerException("Currency not specified");

		if (amount <= 0)
			throw new IllegalArgumentException("Amount must be positive");

		if (banknotes.isEmpty() || cache.isEmpty())
			noMoneyAvailable();

		final List<Banknote> banknotes = this.banknotes.get(currency);
		if (banknotes == null || banknotes.isEmpty())
			noMoneyAvailable();

		final Map<Banknote, Integer> result = new LinkedHashMap<>(); // Using LinkedHashMap to return in good order (from greater to lower)

		for (Banknote banknote : banknotes)
		{
			if (amount == 0)
				break;

			Integer availableBanknotesAmount = cache.get(banknote);
			if (availableBanknotesAmount == null || availableBanknotesAmount == 0)
				continue;

			final int required = amount / banknote.getValue();
			if (required <= availableBanknotesAmount)
			{
				availableBanknotesAmount -= required;
				cache.put(banknote, availableBanknotesAmount);
				result.put(banknote, required);
				amount -= required * banknote.getValue();
				continue;
			}

			cache.remove(banknote);
			result.put(banknote, availableBanknotesAmount);
			amount -= availableBanknotesAmount * banknote.getValue();
		}

		if (amount != 0)
			noMoneyAvailable();

		return result;
	}

	private static void noMoneyAvailable()
	{
		throw new IllegalStateException("No money available");
	}
}
