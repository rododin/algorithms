package org.rododin.algorithms.hackerrank.problem_solving.easy;

/**
 * <a https://www.hackerrank.com/challenges/designer-pdf-viewer/problem">
 *   Practice > Algorithms > Implementation > Designer PDF Viewer
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class DesignerPDFViewer
{
	/**
	 * Implements a trivial and effective solution for computing the selected area as defined in the task.
	 * The complexity is: {@code O(n)}, where <code>n</code> is {@code word.length()}.
	 *
	 * @param heights the heights of the small Latin letters (characters from {@code 'a'} till {@code 'z'} inclusively)
	 *                in millimeters, so the  valid {@code heights.size() = 26} always and {@code 0 ≤ heights[i] ≤ 1000}
	 *                (the constraints are weaker compared with the original task)
	 * @param word    the selected word consisting of the small Latin letters (the characters from {@code 'a'} till
	 *                {@code 'z'} inclusively), where {@code 0 ≤ word.length() ≤ 1000000}
	 *                (the constraints are also weaker compared with the original task)
	 * @return        the selected area in <code>mm<sup>2</sup></code>
	 */
	public static int designerPdfViewer(int[] heights, String word)
	{
		int maxHeight = 0;
		for (char c : word.toCharArray())
		{
			final int h = heights[c - 'a'];
			if (h > maxHeight)
				maxHeight = h;
		}
		return maxHeight * word.length();
	}
}
