package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaSHA256}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSHA256Test
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest("HelloWorld", () -> JavaSHA256.main(null), "872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4");
		doTest("Javarmi123", () -> JavaSHA256.main(null), "f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678");
		doTest("Jav123"    , () -> JavaSHA256.main(null), "2a519844d5104a9331f280c361accda00ced2e11ed3b44b93a3e49d7b847ad57");
	}
}
