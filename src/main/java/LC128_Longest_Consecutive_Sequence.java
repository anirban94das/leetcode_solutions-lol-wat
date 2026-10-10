import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
class LC128_Longest_Consecutive_Sequence {
    //LC: 128. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {

        System.out.println(Arrays.toString(nums));


        Set<Integer> set=new TreeSet<>();

        TreeSet<Integer> treeSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);

        int length=0;
        int max_length=0;
        int current=0;
        for(int i : treeSet){
            System.out.println(i);
            System.out.println("i-1 -> " + (i-1));
            System.out.println("length -> " + length);
            if(treeSet.contains(i-1)){
                length++;
            }else{
                max_length=Math.max(max_length,length);
                length=1;
            }
            current=i;
        }
        System.out.println("max_length->"+max_length);

        return max_length;
    }

    public static void main(String[] args){

        int[] nums_TC1 = {100,4,200,1,3,2};
        int[] nums_TC2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums_TC3 = {1,0,1,2};
        longestConsecutive(nums_TC1);
    }
}
