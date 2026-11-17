import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 */
class LC57_Insert_Intervals {
    //LC: 57. Insert Intervall..
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        List<int[]> out = new ArrayList<>();
        int i=0;
        int len= intervals.length;
        while(i<len){
            int[] current = intervals[i];
            if(current[1]<newInterval[0]){
                //can't merge just add
                out.add(current);
            }
            else
                break;
            i++;
        }
        while(i<len){
            int[] current = intervals[i];
            if(current[0]<=newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],current[0]);
                newInterval[1]=Math.max(newInterval[1],current[1]);
            }else{
                break;
            }
            i++;
        }
        out.add(newInterval);

        while(i<len){
            out.add(intervals[i]);
            i++;
        }
        return  out.toArray(new int[0][]);
    }


}
