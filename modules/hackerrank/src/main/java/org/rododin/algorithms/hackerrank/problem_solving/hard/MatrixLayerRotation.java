package org.rododin.algorithms.hackerrank.problem_solving.hard;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <a href="https://www.hackerrank.com/challenges/matrix-rotation-algo/problem">
 *   HackerRank > Prepare > Algorithms > Implementation > Matrix Layer Rotation
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MatrixLayerRotation
{
	/** This method is taken from HackerRank, and rewritten using {@link Scanner} instead of {@link Reader} API */
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final String[] firstMultipleInput = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

		final int m = Integer.parseInt(firstMultipleInput[0]);
		final int n = Integer.parseInt(firstMultipleInput[1]);
		final int r = Integer.parseInt(firstMultipleInput[2]);

		final List<List<Integer>> matrix = new ArrayList<>();

		IntStream.range(0, m).forEach(i -> matrix.add(
			Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList())
		));

		Result.matrixRotation(matrix, r);

		scanner.close();
	}
}

class Result
{
	public static void matrixRotation(List<List<Integer>> matrix, int r)
	{
		final int m = matrix.size();
		final int n = matrix.get(0).size();
		final int minMN = Math.min(m, n);
		for (int diagonalOffset = 0, do2 = 0; (minMN - do2) > 1; do2 = ++diagonalOffset * 2)
		{
			int mm = m - do2;
			int nn = n - do2;
			final int[] bufCircularArray = subMatrixCircleToArray(matrix, mm, nn, diagonalOffset);
			rotateArray(bufCircularArray, r);
			arrayToSubMatrixCircle(matrix, bufCircularArray, mm, nn, diagonalOffset);
		}
		printMatrix(matrix);
	}

	private static int[] subMatrixCircleToArray(List<List<Integer>> matrix, int mm, int nn, int diagonalOffset)
	{
		final int[] array = new int[2 * (mm + nn - 2)];
		int a = 0;
		for (int i = diagonalOffset; i < diagonalOffset + mm - 1; i++, a++) // submatrix left column, starting from 1st, ending by pre-last, because the last one will be added later (bottom row)
			array[a] = matrix.get(i).get(diagonalOffset);
		for (int j = diagonalOffset; j < diagonalOffset + nn - 1; j++, a++) // submatrix bottom row, starting from 1st, ending by pre-last, because the last one will be added later (right colum)
			array[a] = matrix.get(diagonalOffset + mm - 1).get(j);
		for (int i = diagonalOffset + mm - 1; i > diagonalOffset; i--, a++) // submatrix right column, starting from the last, ending by post-first, because the first one will be added later (top row)
			array[a] = matrix.get(i).get(diagonalOffset + nn - 1);
		for (int j = diagonalOffset + nn - 1; j > diagonalOffset; j--, a++) // submatrix top row, starting from the last, ending by post-first, because the first one is already added above (left column)
			array[a] = matrix.get(diagonalOffset).get(j);
		return array;
	}

	private static void arrayToSubMatrixCircle(List<List<Integer>> matrix, int[] array, int mm, int nn, int diagonalOffset)
	{
		int a = 0;
		for (int i = diagonalOffset; i < diagonalOffset + mm - 1; i++, a++) // submatrix left column, starting from 1st, ending by pre-last, because the last one will be added later (bottom row)
			matrix.get(i).set(diagonalOffset, array[a]);
		for (int j = diagonalOffset; j < diagonalOffset + nn - 1; j++, a++) // submatrix bottom row, starting from 1st, ending by pre-last, because the last one will be added later (right colum)
			matrix.get(diagonalOffset + mm - 1).set(j, array[a]);
		for (int i = diagonalOffset + mm - 1; i > diagonalOffset; i--, a++) // submatrix right column, starting from the last, ending by post-first, because the first one will be added later (top row)
			matrix.get(i).set(diagonalOffset + nn - 1, array[a]);
		for (int j = diagonalOffset + nn - 1; j > diagonalOffset; j--, a++) // submatrix top row, starting from the last, ending by post-first, because the first one is already added above (left column)
			matrix.get(diagonalOffset).set(j, array[a]);
	}

	public static void rotateArray(int[] arr, int r)
	{
		if (arr.length <= 1)
			return;
		r = r % arr.length;
		if (r == 0)
			return;
		for (int count = 0, start = 0; count < arr.length - 1; start++, count++)
		{
			int curElem = arr[start];
			int next = (start + r) % arr.length;
			for ( ; next > start && count < arr.length - 1; next = (next + r) % arr.length, count++)
			{
				final int nextElem = arr[next];
				arr[next] = curElem;
				curElem = nextElem;
			}
			arr[next] = curElem;
		}
	}

	private static void printMatrix(List<List<Integer>> matrix)
	{
		System.out.println(matrix.stream().map(row ->
			row.stream().map(e -> Integer.toString(e)).collect(Collectors.joining(" "))).collect(Collectors.joining("\n")));
	}
}
