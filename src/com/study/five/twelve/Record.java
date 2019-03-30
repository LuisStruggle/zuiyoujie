package com.study.five.twelve;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 进阶题目：如果查询发生的次数有很多，如何把每次查询的时间复杂度降为O(1)?
 * 
 * 描述：本书实现的记录其实是一个哈希表HashMap<String,
 * HashMap<String,Integer>>，这是一个key为string类型、value为哈希表类型的哈希表。
 * 
 * @author zhangyundu
 *
 */
public class Record {
	private HashMap<String, HashMap<String, Integer>> record;

	public Record(String[] strArr) {
		record = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
		for (int i = 0; i != strArr.length; i++) {
			String curStr = strArr[i];
			update(indexMap, curStr, i);
			indexMap.put(curStr, i);
		}
	}

	private void update(HashMap<String, Integer> indexMap, String str, int i) {
		// TODO Auto-generated method stub
		if (!record.containsKey(str)) {
			record.put(str, new HashMap<String, Integer>());
		}
		HashMap<String, Integer> strMap = record.get(str);

		for (Entry<String, Integer> lastEntry : indexMap.entrySet()) {
			String key = lastEntry.getKey();
			int index = lastEntry.getValue();
			if (!key.equals(str)) {
				HashMap<String, Integer> lastMap = record.get(key);
				int curMin = i - index;
				if (strMap.containsKey(key)) {
					int preMin = strMap.get(key);
					if (curMin < preMin) {
						strMap.put(key, curMin);
						lastMap.put(str, curMin);
					}
				} else {
					strMap.put(key, curMin);
					lastMap.put(str, curMin);
				}
			}
		}
	}

	public int minDistance(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return -1;
		}
		if (str1.equals(str2)) {
			return 0;
		}
		if (record.containsKey(str1) && record.get(str1).containsKey(str2)) {
			return record.get(str1).get(str2);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Record r = new Record(
				new String[] { "1", "3", "3", "3", "2", "3", "1" });
		System.out.println(r.minDistance("1", "2"));
	}
}
