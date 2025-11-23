package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaPriorityQueue}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaPriorityQueueTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest
			(stringsToStringByLine
					( """
						12
						ENTER John 3.75 50
						ENTER Mark 3.8 24
						ENTER Shafaet 3.7 35
						SERVED
						SERVED
						ENTER Samiha 3.85 36
						SERVED
						ENTER Ashley 3.9 42
						ENTER Maria 3.6 46
						ENTER Anik 3.95 49
						ENTER Dan 3.95 50
						SERVED
						"""
					)
				, () -> JavaPriorityQueue.main(null)
				, stringsToStringByLine
					( """
						Dan
						Ashley
						Shafaet
						Maria
						"""
					)
			);
	}
}
