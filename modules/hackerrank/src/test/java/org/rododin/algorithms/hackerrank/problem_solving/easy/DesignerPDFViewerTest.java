package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link DesignerPDFViewer}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class DesignerPDFViewerTest
{
	@Test
	public void testCornerCases()
	{
		Assert.assertEquals(0, DesignerPDFViewer.designerPdfViewer(new int[] {}, ""));
		Assert.assertEquals(0, DesignerPDFViewer.designerPdfViewer(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, ""));
		Assert.assertThrows(IndexOutOfBoundsException.class, () -> DesignerPDFViewer.designerPdfViewer(new int[] {}, "abc"));
		Assert.assertEquals(2600, DesignerPDFViewer.designerPdfViewer(new int[] {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}, "abcdefghijklmnopqrstuvwxyz"));
	}

	@Test
	public void testHRCases()
	{
		Assert.assertEquals(8 , DesignerPDFViewer.designerPdfViewer(new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 1, 1, 5, 5, 1, 5, 2, 5, 5, 5, 5, 5, 5}, "torn"));
		Assert.assertEquals(9 , DesignerPDFViewer.designerPdfViewer(new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "abc" ));
		Assert.assertEquals(28, DesignerPDFViewer.designerPdfViewer(new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, "zaba"));
	}
}
