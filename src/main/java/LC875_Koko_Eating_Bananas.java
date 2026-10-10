import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
class LC875_Koko_Eating_Bananas {
    //LC: 875. Koko Eating Bananas

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        int low=1; int high = piles[piles.length-1];
        int mid=0;
        while(low<high){
            mid=(low+high)/2;
            int time_taken=find_time_taken(piles,mid);
            if(time_taken<=h){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        System.out.println(low);

        return low;
    }
    public int find_time_taken(int[] piles, int speed) {
        int sum=0;
        for (int heap : piles) {
            sum+= (int) Math.ceil((double) heap /speed);
        }
        return sum;
    }


    public static void main(String[] args){

        int[] nums_TC1 = {100,4,200,1,3,2};
        int[] nums_TC2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums_TC3 = {1,0,1,2};
//        minEatingSpeed(nums_TC1,1);
    }
}
