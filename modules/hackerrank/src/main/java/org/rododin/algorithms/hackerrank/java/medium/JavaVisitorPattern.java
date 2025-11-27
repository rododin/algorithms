package org.rododin.algorithms.hackerrank.java.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum Color
{
	RED, GREEN
}

abstract class Tree
{
	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth)
	{
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue()
	{
		return value;
	}

	public Color getColor()
	{
		return color;
	}

	public int getDepth()
	{
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree
{
	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth)
	{
		super(value, color, depth);
	}

	public void accept(TreeVis visitor)
	{
		visitor.visitNode(this);

		for (Tree child : children)
		{
			child.accept(visitor);
		}
	}

	public void addChild(Tree child)
	{
		children.add(child);
	}
}

class TreeLeaf extends Tree
{
	public TreeLeaf(int value, Color color, int depth)
	{
		super(value, color, depth);
	}

	public void accept(TreeVis visitor)
	{
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis
{
	public abstract int getResult();
	public abstract void visitNode(TreeNode node);
	public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis
{
	private int sum = 0;

	public int getResult()
	{
		//implement this
		return sum;
	}

	public void visitNode(TreeNode node)
	{
		//implement this
		//nothing to do
	}

	public void visitLeaf(TreeLeaf leaf)
	{
		//implement this
		sum += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis
{
	private static final long MOD = 1_000_000_000 + 7;
	private long product = 1;

	public int getResult()
	{
		//implement this
		return (int)(product % (MOD));
	}

	public void visitNode(TreeNode node)
	{
		//implement this
		if (node.getColor() == Color.RED)
			product = (product * (node.getValue() != 0 ? node.getValue() : 1)) % MOD;
	}

	public void visitLeaf(TreeLeaf leaf)
	{
		//implement this
		if (leaf.getColor() == Color.RED)
			product = (product * (leaf.getValue() != 0 ? leaf.getValue() : 1)) % MOD;
	}
}

class FancyVisitor extends TreeVis
{
	private int edenDepthNodesSum = 0;
	private int greenLeafsSum = 0;

	public int getResult()
	{
		//implement this
		return Math.abs(edenDepthNodesSum - greenLeafsSum);
	}

	public void visitNode(TreeNode node)
	{
		//implement this
		if (node.getDepth() % 2 == 0)
			edenDepthNodesSum += node.getValue();
	}

	public void visitLeaf(TreeLeaf leaf)
	{
		//implement this
		if (leaf.getColor() == Color.GREEN)
			greenLeafsSum += leaf.getValue();
	}
}

/**
 * <a href="https://www.hackerrank.com/challenges/java-vistor-pattern/problem">
 *   HackerRank > Prepare > Java > Advanced > Java Visitor Pattern
 * </a> Problem Solution.
 * <p>
 * NOTE: At HackerRank this class is named {@code Solution}. The methods {@link #solve()} and its recursive companion
 *       {@link #createTree(int[], Color[], Map, int, int, int)} implement the 2nd part of the requested solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaVisitorPattern
{
	public static Tree solve()
	{
		//read the tree from STDIN and return its root as a return value of this function
		final Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();
		final int[] nodeValues = new int[n];
		for (int i = 0; i < n; i++)
			nodeValues[i] = scanner.nextInt();
		final Color[] nodeColors = new Color[n];
		for (int i = 0; i < n; i++)
			nodeColors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
		final Map<Integer, List<Integer>> edges = new HashMap<>();
		for (int i = 1; i < n; i++)
		{
			final int from = scanner.nextInt();
			final int to = scanner.nextInt();
			// We need both-way directions,
			// because it's not guaranteed that the left (first) node is deeper (closer to the root) in the tree,
			// i.e. the nodes (vertexes) for the edge may be defined in any order.
			addToEdges(edges, from, to);
			addToEdges(edges, to, from);
		}
		scanner.close();

		return createTree(nodeValues, nodeColors, edges, 1, 0, 0); // For the root node, assuming the parent node index is 0, because the root node index is 1
	}

	private static void addToEdges(Map<Integer, List<Integer>> edges, int from, int to)
	{
		// We need to write it in Java 7, because on HackerRank there is a solution template available for Java 7 only.
		// Otherwise, in Java 8+, we could use the Map.compute() method and lambdas to write it more elegant.
		List<Integer> subNodes = edges.get(from);
		if (subNodes == null)
		{
			subNodes = new ArrayList<>();
			edges.put(from, subNodes);
		}
		subNodes.add(to);
	}

	private static Tree createTree(int[] nodeValues, Color[] nodeColors, Map<Integer, List<Integer>> edges, int nodeIndex, int parentNodeIndex, int depth)
	{
		final List<Integer> linkedNodeIndexes = edges.get(nodeIndex);
		if (linkedNodeIndexes == null || (linkedNodeIndexes.size() == 1 && linkedNodeIndexes.get(0) == parentNodeIndex))
			// it's a leaf, creating it and returning it
			return new TreeLeaf(nodeValues[nodeIndex-1], nodeColors[nodeIndex-1], depth);

		final TreeNode newNode = new TreeNode(nodeValues[nodeIndex-1], nodeColors[nodeIndex-1], depth);
		for (Integer subNodeIndex : linkedNodeIndexes)
		{
			// As we have both-way direction links within edges, the linkedNodeIndexes contains not only links to child nodes, but also to parent one
			if (subNodeIndex != parentNodeIndex)
				newNode.addChild(createTree(nodeValues, nodeColors, edges, subNodeIndex, nodeIndex, depth + 1));
		}
		return newNode;
	}

	public static void main(String[] args)
	{
		Tree root = solve();

		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
