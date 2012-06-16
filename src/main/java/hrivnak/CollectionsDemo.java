package hrivnak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

public class CollectionsDemo {
	public static void main(String[] args) {
		sets();
		multiSets();
		sortedMultiSets();
		maps();
		lists();
	}

	private static void sets() {
		Set<ClassWithSuperLongClassNameToHelpProveMyPoint> regularSet = new HashSet<ClassWithSuperLongClassNameToHelpProveMyPoint>();
		Set<ClassWithSuperLongClassNameToHelpProveMyPoint> guavaSet = Sets.newHashSet();

		Set<String> handyForUnitTesting = Sets.newHashSet("this", "is", "pretty", "handy", "for", "making", "quick",
		        "data", "sets");

		ImmutableSet<String> alsoHandy = ImmutableSet.of("another", "handy", "way", "to", "initialize", "a", "set",
		        "that", "is", "immutable");
	}

	private static void multiSets() {
		Multiset<String> multiSet = ImmutableMultiset.of("one", "two", "two", "three", "three", "three");

		// if you iterate, you do so over all values not just unique values
		printCollection("iterating over the Multiset:", multiSet);

		System.out.println("multiSet.size() = " + multiSet.size());
		System.out.println("multiSet.elementSet().size() = " + multiSet.elementSet().size());
		System.out.println("multiSet.count(\"one\") = " + multiSet.count("one"));
		System.out.println("multiSet.count(\"two\") = " + multiSet.count("two"));
		System.out.println("multiSet.count(\"three\") = " + multiSet.count("three"));
	}

	private static void sortedMultiSets() {
		SortedMultiset<Integer> latencies = TreeMultiset.create();
		latencies.addAll(Arrays.asList(12, 15, 18, 10, 2, 5, 39, 3, 8, 9, 7, 7, 30, 32, 27, 22, 29, 19, 35));

		printCollection("iterating over the SortedMultiset:", latencies);

		// let's see how many latencies were below 25
		SortedMultiset<Integer> latenciesBelow25 = latencies.subMultiset(0, BoundType.CLOSED, 25, BoundType.OPEN);
		int numBelow25 = latenciesBelow25.size();
		int totalNum = latencies.size();
		System.out.println("number of latencies below 25 = " + numBelow25);
		System.out.println("percentage of latencies below 25 = " + ((double) numBelow25 / (double) totalNum) * 100.0);
	}

	private static void maps() {
		Map<String, ClassWithSuperLongClassNameToHelpProveMyPoint> regularMap = new HashMap<String, ClassWithSuperLongClassNameToHelpProveMyPoint>();
		Map<String, ClassWithSuperLongClassNameToHelpProveMyPoint> guavaMap = Maps.newHashMap();

		Map<String, Integer> handyForUnitTests = ImmutableMap.of("one", 1, "two", 2, "three", 3);
	}

	private static void lists() {
		List<ClassWithSuperLongClassNameToHelpProveMyPoint> regularList = new ArrayList<ClassWithSuperLongClassNameToHelpProveMyPoint>();
		List<ClassWithSuperLongClassNameToHelpProveMyPoint> guavaList = Lists.newArrayList();

		List<String> forward = Lists.newArrayList("we", "can", "initialize", "lists", "here");
		List<String> backwardView = Lists.reverse(forward);

		printCollection("list:", forward);
		printCollection("list reversed:", backwardView);

		// let's see what happens when we remove an element from the backwardView
		backwardView.remove("initialize");
		printCollection("list:", forward);
		printCollection("list reversed:", backwardView);
	}

	private static <T> void printCollection(String title, Collection<T> collection) {
		System.out.println(title);
		for (T element : collection) {
			System.out.println("\t" + element);
		}
	}
}