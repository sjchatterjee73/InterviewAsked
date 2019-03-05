/*
  Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

  You may assume that the intervals were initially sorted according to their start times.
  
  Example 1:

  Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
  Output: [[1,5],[6,9]]
  Example 2:

  Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
  Output: [[1,2],[3,10],[12,16]]
  Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
  
  Prerequisite: Merge Intervals.
  
  url: https://leetcode.com/problems/insert-interval/
*/
class Solution {
    void sort(int [] intervals, int [] auxilaries){
        for(int i=1; i<intervals.length; i++){
            int key = intervals[i];
            int key1 = auxilaries[i];
            
            int j = i-1;
            
            while(j>=0 && key <= intervals[j]){
                intervals[j+1] = intervals[j];
                auxilaries[j+1] = auxilaries[j];
                --j;
            }
            
            intervals[j+1] = key;
            auxilaries[j+1] = key1;
        }
    }
    
    List<Interval> mergeIntervals(int [] intervals, int [] auxilaries){
        List<Interval> list = new ArrayList<Interval>();
        int f = intervals[0];
        int l = auxilaries[0];
        int flag = 0;
        for(int i=1; i<intervals.length; i++){        	
            if(intervals[i] <= l){
                 if(auxilaries[i] >= l)
                 	l = auxilaries[i];               
            }else{
                Interval obj = new Interval(f, l);
                list.add(obj);
                f = intervals[i];
                l = auxilaries[i];
            }
            flag = i;
        }

        if(intervals[flag] <= l)
	   		if(auxilaries[flag] >= l)
				l = auxilaries[flag];
	       	
        Interval obj = new Interval(f, l);
        list.add(obj);
        return list;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int [] intValues = new int[intervals.size()+1];
        int [] auxValues = new int[intervals.size()+1];
        
        for(int i=0; i<intValues.length-1; i++){
            Interval obj = intervals.get(i);
            intValues[i] = obj.start;
            auxValues[i] = obj.end;
        }
        intValues[intValues.length-1] = newInterval.start;
        auxValues[intValues.length-1] = newInterval.end;
        sort(intValues, auxValues);
        
        return mergeIntervals(intValues, auxValues);
    }
}
