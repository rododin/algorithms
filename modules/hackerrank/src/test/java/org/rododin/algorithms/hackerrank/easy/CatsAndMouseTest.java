/*
 * CatsAndMouseTest.java
 */

package org.rododin.algorithms.hackerrank.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link CatsAndMouse}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CatsAndMouseTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals("Cat B", CatsAndMouse.printCatAndMouse(2, 5, 4));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("Cat B", CatsAndMouse.printCatAndMouse(1, 2, 3));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals("Mouse C", CatsAndMouse.printCatAndMouse(1, 3, 2));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals("Cat A", CatsAndMouse.printCatAndMouse(19, 31, 22));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals("Mouse C", CatsAndMouse.printCatAndMouse(0, 0, 0));
	}
}
