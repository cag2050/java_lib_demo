package collections;

import java.util.Collections;
import java.util.Arrays;

import java.util.Collection;
import java.util.Iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import java.util.IdentityHashMap;

public class CollectionsDemo {

	static void displayAll(Collection collection) {
		Iterator itr = collection.iterator();
		while (itr.hasNext()) {
//			注意：当object为null 时，String.valueOf(object)的值是字符串”null”，而不是null
			String str = String.valueOf(itr.next());
			System.out.print(str + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<String> linkedList = new LinkedList<String>();
		// Vector与ArrayList的用法几乎完全相同，二者之间的最大区别在于Vector类是线程安全的，而ArrayList不是
		List<String> vector = new Vector<String>();

		Set<String> treeSet = new TreeSet<String>();
		Set<String> hashSet = new HashSet<String>();
		Set<String> linkedHashSet = new LinkedHashSet<String>();

		Map<String, String> treeMap = new TreeMap<String, String>();
		Map<String, String> hashMap = new HashMap<String, String>();
		// Hashtable与HashMap的用法几乎相同,Hashtable是线程安全的，而HashMap不是。
		// 此外，Hashtable不允许key和value为null，而HashMap是允许的
		Map<String, String> hashtable = new Hashtable<String, String>();
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		Map<String, String> weakHashMap = new WeakHashMap<String, String>();
		Map<String, String> identityHashMap = new IdentityHashMap<String, String>();

		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		System.out.println("arrayList 为：");
		displayAll(arrayList);

		linkedHashSet.add("set1");
		linkedHashSet.add(null);
		linkedHashSet.add("set3");
		System.out.println("linkedHashSet 为：");
		displayAll(linkedHashSet);

		treeMap.put("CN", "CHINA");
		treeMap.put("EN", "America");
		System.out.println("treeMap 的keys为：");
		displayAll(treeMap.keySet());
		System.out.println("treeMap 的values为：");
		displayAll(treeMap.values());
		System.out.println("treeMap 的entry为：");
		Iterator<Map.Entry<String, String>> it = treeMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " value= " + entry.getValue());
		}
		
	}

}
