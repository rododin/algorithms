package org.rododin.algorithms.yandex.interview1;

import java.util.HashMap;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 * <p>
 * Другие валюты и номиналы должны легко добавляться разработчиками в будущем.
 * Многопоточные сценарии могут быть добавлены позже (например резервирование).
 * <p>
 * Версия 1, реализованная на интервью №1.
 */
public class ATM1
{
	public enum CurrencyValue
	{
		Rouble50   (  50),
		Rouble100  ( 100),
		Rouble500  ( 500),
		Rouble1000 (1000),
		Rouble5000 (5000);

		CurrencyValue(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}

		private int value;
	}

	public enum Error
	{
		NoMoney,

	}

	public static class GetMoneyResult
	{
		Error error;
		Map<CurrencyValue, Integer> money;

		public GetMoneyResult(Error error, Map<CurrencyValue, Integer> money)
		{
			this.error = error;
			this.money = money;
		}

		public Error getError()
		{
			return error;
		}

		public Map<CurrencyValue, Integer> getMoney()
		{
			return money;
		}
	}

	private Map<CurrencyValue, Integer> availableMoney = new HashMap<>();

	public ATM1 init(CurrencyValue currencyValue, int amount)
	{
		availableMoney.put(currencyValue, amount);
		return this;
	}

	public Map<CurrencyValue, Integer> getAvailableMoney()
	{
		return availableMoney;
	}

	public GetMoneyResult getMoney(int howMuch)
	{
		Map<CurrencyValue, Integer> availableMoney = new HashMap<>(this.availableMoney);
		final Map<CurrencyValue, Integer> result = new HashMap<>();
		//int remainOfUnits = 0;

		for (int i = CurrencyValue.values().length-1; i >=0; i--)
		{
			final CurrencyValue cv = CurrencyValue.values()[i];
			final int value = cv.getValue();
			int numberOfUnits = howMuch / value;

			final Integer availableUnitsInteger = availableMoney.get(cv);
			final int availableUnits = availableUnitsInteger != null ? availableUnitsInteger : 0;
			if (availableUnits < numberOfUnits)
			{
				if (availableUnits > 0)
					numberOfUnits = availableMoney.remove(cv);
				else
					numberOfUnits = 0;
			}
			else
				availableMoney.put(cv, availableUnits - numberOfUnits);

			if (numberOfUnits == 0)
				continue;
			result.put(cv, numberOfUnits);
			howMuch -= numberOfUnits * value;

			//remainOfUnits = howMuch % value;
			//if (remainOfUnits == 0)
			//	break;
		}

		if (result.isEmpty() || howMuch != 0)
			return new GetMoneyResult(Error.NoMoney, result);
		else
		{
			this.availableMoney = availableMoney;
			return new GetMoneyResult(null, result);
		}
	}
}

