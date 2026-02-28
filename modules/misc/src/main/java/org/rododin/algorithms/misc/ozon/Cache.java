package org.rododin.algorithms.misc.ozon;

import java.util.Map;

/**
 * Нужно реализовать "кэш", который хранит лонги по индексу {@code [0..N)}.
 * Размер кэша - {@code N=10} элементов.
 * <p>
 * Условия:
 * <ul>
 *   <li>Есть несколько потоков, которые кэш читают.</li>
 *   <li>Есть один поток, который кэш обновляет.</li>
 *   <li>Читатель должен видеть только конечное состояние, но никогда не промежуточное.</li>
 *   <li>Чтение должно быть неблокирующим и неблокирующимся.</li>
 *   <li>Запись может быть блокирующей.</li>
 * </ul>
 */
public interface Cache
{
	void bulkUpdate(Map<Integer, Long> updates);
	long[] bulkGet(int[] indexes);
}
