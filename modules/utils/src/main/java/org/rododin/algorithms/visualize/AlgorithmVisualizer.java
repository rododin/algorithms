package org.rododin.algorithms.visualize;

import java.io.PrintStream;

/**
 * Introduces a very common and unified algorithm visualizer, which may be directly useful for visualizing
 * start data sets and final algorithm work results as well as some intermediate steps in the common formated text form
 * (aka {@link String#format(String, Object...)} or {@link PrintStream#printf(String, Object...)} format style).
 * Certain algorithm implementation may need to use more advanced visualizers specially developed for those algorithms.
 * For some graphical visualization we may also need appropriate algorithm adaptations, because detailed visualization
 * may be deeply dependent on the algorithm implementation.
 * Thus, this interface may serve as a parent for a wide family of very different unified as well as algorithm-specific
 * visualization implementations.
 *
 * @author Nikolay Chebotaryov
 */
@FunctionalInterface
public interface AlgorithmVisualizer
{
	void visualize(String formatedText, Object... args);

	default void visualizeLn(String formatedText, Object... args)
	{
		visualize(formatedText + "\n", args);
	}
}
