package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * @author xujian
 * Merge Intervals
 */
public class LeetCode_56 {

	public static List<Interval> merge(List<Interval> intervals){
		if(intervals == null || intervals.size() == 0){
			return intervals;
		}
		//sort intervals based on their left opening
		//compatator function is very important
		List<Interval> result = new ArrayList<Interval>();
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});
		Interval iv = null;
		Interval ik = null;
		Iterator<Interval> iterator = intervals.iterator();
		while(iterator.hasNext()){
			iv = iterator.next();
			if(ik == null){
				//initialization
				ik = new Interval(iv.start, iv.end);
			}
			else{
				if(iv.start <= ik.end){
					ik = new Interval(ik.start,Math.max(iv.end,ik.end));
				}
				else{
					result.add(ik);
					ik = iv;
				}
			}
		}
		if(ik != null){
			result.add(ik);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		List<Interval> result = new ArrayList<Interval>();
		result.add(i1);
		result.add(i2);
		result.add(i3);
		result.add(i4);
		List<Interval> results = merge(result);
		for(Interval i : results){
			System.out.println(i.start + " " + i.end);
		}
	}

}
