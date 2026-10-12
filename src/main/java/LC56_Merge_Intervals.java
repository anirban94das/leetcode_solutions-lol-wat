import java.util.*;

/**
 * https://leetcode.com/problems/two-sum/
 */
class LC56_Merge_Intervals {
    //LC: 1. Two Sum
    public int[][] merge(int[][] intervals) {

        List<Interval> sortedIntervalList=new ArrayList<>();
        for(int interval[]:intervals){
            sortedIntervalList.add(new Interval(interval[0], interval[1]));
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        sortedIntervalList.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
      for()


        return new int[][] {{1,2}};
    }


    class Interval{
            public int start;
            public int end;

        Interval(int s, int e){
            start=s;
            end=e;
        }
    }

}
