import java.util.List;
import java.util.function.Consumer;

import org.rododin.algorithms.measure.ComputationComplexity;
import org.rododin.algorithms.visualize.AlgorithmVisualizer;

/**
 * Introduces a concept of some abstract algorithm which can be {@link #visualize(AlgorithmVisualizer) visualized}
 * and {@link ComputationComplexity estimated}.
 * <p>
 * NOTE: This {@link Algorithm} definition does NOT introduce any algorithm job execution method, because a real
 *       job execution method may very depend on the algorithm implementation, its purpose and entering data set.
 *       So, we don't want to complicate the job execution process with some unified API
 *
 * @author Nikolay Chebotaryov
 */
public interface Algorithm
	<V extends AlgorithmVisualizer>
{
	/**
	 * Sets given visualizer to manage the algorithm visualization process and returns this {@link Algorithm} instance
	 * for chaining calls. Generally the visualizer should be set before the algorithm is doing its job, but it may depend
	 * on certain algorithm implementation.
	 *
	 * @param visualizer An {@link AlgorithmVisualizer} instance to be used for visualization, or {@code null} to avoid
	 *                   any visualization.
	 * @return The same instance of {@link Algorithm} for chaining calls.
	 */
	Algorithm<V> visualize(V visualizer);

	/**
	 * Enables the algorithm {@link ComputationComplexity computation complexity} estimation and returns this
	 * {@link Algorithm} instance for chaining calls. The estimated complexity may be visualized at the end of the
	 * algorithm job using the configured {@link #visualize(AlgorithmVisualizer) visualizer}, and/or may be consumed
	 * using the given {@link Consumer estimationConsumer}, that all depends on the algorithm implementation.
	 * Note, generally, to obtain more precise {@link ComputationComplexity estimation} the algorithm job should be
	 * executed multiple times of very different data sets, or in different running conditions. So, results of multiple
	 * runs may be collected using the given {@link Consumer estimationConsumer} into a list and then passed to
	 * {@link ComputationComplexity#estimateO(List)} for getting the final estimation.
	 *
	 * @param estimationConsumer Non-{@code null} consumer to enable and consume the estimation results, or empty
	 *                           (aka do-nothing) consumer to still estimate and visualize (if enabled) the estimation,
	 *                           or {@code null} to disable the estimation.
	 * @return The same instance of {@link Algorithm} for chaining calls.
	 */
	Algorithm<V> estimate(Consumer<ComputationComplexity> estimationConsumer);
}
