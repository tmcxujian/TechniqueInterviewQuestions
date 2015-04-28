package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author xujian
 * Insert Intervals
 */
public class LeetCode_57 {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null){
			return intervals;
		}
		intervals.add(newInterval);
		intervals = merge(intervals);
        return intervals;
    }
	
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
	
	//This one does not contain the methods in merge 
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		int i = 0;
		while(i < intervals.size() && intervals.get(i).end < newInterval.start){
			result.add(intervals.get(i));
			i++;
		}
		while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
			int x = Math.min(intervals.get(i).start, newInterval.start);
			int y = Math.max(intervals.get(i).end, newInterval.end);
			newInterval = new Interval(x,y);
			i++;
		}
		result.add(newInterval);
		while(i < intervals.size() && intervals.get(i).start > newInterval.end){
			result.add(intervals.get(i));
			i++;
		}
		return result;
	}
}
