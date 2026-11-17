import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
class LC56_Merge_Intervals {
    //LC: 1. Two Sum Merge Itnervals
     public int[][] merge(int[][] intervals) {
        //Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


         List<int[]> out = new ArrayList<>();
        for (int[] current : intervals) {

            if(out.isEmpty()){
                out.add(current);
            }else {
                int[] lastInterval = out.get(out.size() - 1);

                if(lastInterval[1]<current[0]){
                    out.add(current);
                } else if (lastInterval[1]>=current[0]) {
                    lastInterval[1]=Math.max(lastInterval[1], current[1]);
                }
            }
        }
        return out.toArray(new int[0][]);
    }


}
