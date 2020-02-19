package org.rododin.algorithms.misc.budget_shopping;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.file.FileUtils;
import org.rododin.algorithms.function.TriFunction;

/**
 * Unit Test(s) for <code>{@link BudgetShopping}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BudgetShoppingTest
{
	@Test
	public void test1()
	{
		runTest("org.rododin.algorithms.misc.budget_shopping/budget_shopping_test_01.txt", BudgetShopping::bruteForceSearch);
	}

	@Test
	public void test2()
	{
		runTest("org.rododin.algorithms.misc.budget_shopping/budget_shopping_test_02.txt", BudgetShopping::bruteForceSearch);
	}

	@Test
	public void test3()
	{
		runTest("org.rododin.algorithms.misc.budget_shopping/budget_shopping_test_03.txt", BudgetShopping::bruteForceSearch);
	}

	private static List<Integer> readTestInput(String resourceName)
	{
		return FileUtils.readResourceByLine(resourceName).map(Integer::parseInt).collect(Collectors.toList());
	}

	private static void runTest(String resourceName, TriFunction<Integer, int[], int[], Integer> algImpl)
	{
		final Iterator<Integer> inputIt = readTestInput(resourceName).iterator();
		final int n = inputIt.next();
		final int m1 = inputIt.next();
		final int[] bundleQuantities = new int[m1];
		for (int i = 0; i < m1; i++)
			bundleQuantities[i] = inputIt.next();
		final int m2 = inputIt.next();
		Assert.assertEquals(m1, m2);
		final int[] bundlePrices = new int[m2];
		for (int i = 0; i < m1; i++)
			bundlePrices[i] = inputIt.next();
		final int expResult = inputIt.next();

		final int result = algImpl.apply(n, bundleQuantities, bundlePrices);

		Assert.assertEquals(expResult, result);
	}
}
