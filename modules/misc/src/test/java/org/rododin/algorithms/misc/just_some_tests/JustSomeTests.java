package org.rododin.algorithms.misc.just_some_tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov
 */
public class JustSomeTests
{
	@Test
	public void testEmptyOptional()
	{
		final List<Long> list1 = Collections.emptyList();
		final List<Long> list2 = new ArrayList<>();
		final List<Long> list3 = Arrays.asList(1L, 2L, 3L);

		Assert.assertNull(list1.stream().filter(item -> item.equals(4L)).findFirst().orElse(null));
		Assert.assertNull(list2.stream().filter(item -> item.equals(4L)).findFirst().orElse(null));
		Assert.assertNull(list3.stream().filter(item -> item.equals(4L)).findFirst().orElse(null));

		Assert.assertEquals(Long.valueOf(3L), list3.stream().filter(item -> item.equals(3L)).findFirst().orElse(null));
	}


}
