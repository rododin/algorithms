package org.rododin.algorithms.yandex.interview1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit Test(s) for <code>{@link ATM1}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ATM1Test
{
	@Test
	public void testInit()
	{
		final ATM1 atm = new ATM1().init(ATM1.CurrencyValue.Rouble5000, 100)
		                           .init(ATM1.CurrencyValue.Rouble1000, 100)
		                           .init(ATM1.CurrencyValue.Rouble500, 200)
		                           .init(ATM1.CurrencyValue.Rouble100, 500)
		                           .init(ATM1.CurrencyValue.Rouble50, 1000);


		Assertions.assertEquals(100, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble5000));
		Assertions.assertEquals(100, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble1000));
		Assertions.assertEquals(200, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble500));
		Assertions.assertEquals(500, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble100));
		Assertions.assertEquals(1000, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble50));
	}

	@Test
	public void test1()
	{
		final ATM1 atm = new ATM1().init(ATM1.CurrencyValue.Rouble5000, 100)
		                           .init(ATM1.CurrencyValue.Rouble1000, 100)
		                           .init(ATM1.CurrencyValue.Rouble500, 200)
		                           .init(ATM1.CurrencyValue.Rouble100, 500)
		                           .init(ATM1.CurrencyValue.Rouble50, 1000);

		final ATM1.GetMoneyResult moneyResult = atm.getMoney(1250);
		Assertions.assertNull(moneyResult.error);
		Assertions.assertEquals(1, moneyResult.money.get(ATM1.CurrencyValue.Rouble1000));
		Assertions.assertEquals(2, moneyResult.money.get(ATM1.CurrencyValue.Rouble100));
		Assertions.assertEquals(1, moneyResult.money.get(ATM1.CurrencyValue.Rouble50));

		Assertions.assertEquals(100, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble5000));
		Assertions.assertEquals( 99, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble1000));
		Assertions.assertEquals(200, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble500));
		Assertions.assertEquals(498, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble100));
		Assertions.assertEquals(999, atm.getAvailableMoney().get(ATM1.CurrencyValue.Rouble50));
	}

	@Test
	public void test2()
	{
		final ATM1 atm = new ATM1().init(ATM1.CurrencyValue.Rouble1000, 1)
		                         .init(ATM1.CurrencyValue.Rouble100, 2)
		                         .init(ATM1.CurrencyValue.Rouble50, 1);

		final ATM1.GetMoneyResult moneyResult1 = atm.getMoney(1300);
		Assertions.assertEquals(ATM1.Error.NoMoney, moneyResult1.error);

		final ATM1.GetMoneyResult moneyResult2 = atm.getMoney(1250);
		Assertions.assertNull(moneyResult2.error);
		Assertions.assertEquals(1, moneyResult2.money.get(ATM1.CurrencyValue.Rouble1000));
		Assertions.assertEquals(2, moneyResult2.money.get(ATM1.CurrencyValue.Rouble100));
		Assertions.assertEquals(1, moneyResult2.money.get(ATM1.CurrencyValue.Rouble50));
	}
}
