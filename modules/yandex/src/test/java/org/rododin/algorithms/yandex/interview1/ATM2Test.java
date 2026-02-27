package org.rododin.algorithms.yandex.interview1;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit Test(s) for <code>{@link ATM2}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ATM2Test
{
	@Test
	public void testInit()
	{
		final ATM2 atm = new ATM2();
		atm.init(Map.of( ATM2.Banknotes.Rouble5000.get(),  100
		               , ATM2.Banknotes.Rouble1000.get(),  200
		               , ATM2.Banknotes.Rouble500 .get(),  400
		               , ATM2.Banknotes.Rouble100 .get(), 1000
		               , ATM2.Banknotes.Rouble50  .get(), 2000
		               )
		        );

		final Map<ATM2.Currency, List<ATM2.Banknote>> availableBanknotes = atm.getAvailableBanknotes();
		final Map<ATM2.Banknote, Integer> availableCache = atm.getAvailableCache();

		Assertions.assertEquals(1, availableBanknotes.size());
		Assertions.assertEquals(ATM2.Rouble, availableBanknotes.keySet().iterator().next());
		Assertions.assertTrue(availableBanknotes.values().iterator().next().containsAll(
			Set.of( ATM2.Banknotes.Rouble5000.get()
			      , ATM2.Banknotes.Rouble1000.get()
			      , ATM2.Banknotes.Rouble500 .get()
			      , ATM2.Banknotes.Rouble100 .get()
			      , ATM2.Banknotes.Rouble50  .get()
			      )));

		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble5000.get()),  100);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble1000.get()),  200);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble500 .get()),  400);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble100 .get()), 1000);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble50  .get()), 2000);
	}

	@Test
	public void testWithdraw17950()
	{
		final ATM2 atm = new ATM2();
		atm.init(Map.of( ATM2.Banknotes.Rouble5000.get(),  100
		               , ATM2.Banknotes.Rouble1000.get(),  200
		               , ATM2.Banknotes.Rouble500 .get(),  400
		               , ATM2.Banknotes.Rouble100 .get(), 1000
		               , ATM2.Banknotes.Rouble50  .get(), 2000
		               )
		        );

		final Map<ATM2.Banknote, Integer> withdrawnCache = atm.withdraw(ATM2.Rouble, 17950);

		Assertions.assertEquals(withdrawnCache.get(ATM2.Banknotes.Rouble5000.get()), 3);
		Assertions.assertEquals(withdrawnCache.get(ATM2.Banknotes.Rouble1000.get()), 2);
		Assertions.assertEquals(withdrawnCache.get(ATM2.Banknotes.Rouble500 .get()), 1);
		Assertions.assertEquals(withdrawnCache.get(ATM2.Banknotes.Rouble100 .get()), 4);
		Assertions.assertEquals(withdrawnCache.get(ATM2.Banknotes.Rouble50  .get()), 1);

		final Map<ATM2.Banknote, Integer> availableCache = atm.getAvailableCache();

		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble5000.get()),   97);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble1000.get()),  198);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble500 .get()),  399);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble100 .get()),  996);
		Assertions.assertEquals(availableCache.get(ATM2.Banknotes.Rouble50  .get()), 1999);
	}


}
