import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class LC215_kth_Largest_Element {

    //LC: 215. kth Largest Element
    public int findKthLargest(int[] nums, int k)
    {

        HashSet<Integer> hashSet=new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(hashSet.contains(nums[i])){
                continue;
            }
            minHeap.offer(nums[i]);
            hashSet.add(nums[i]);
            if(minHeap.size()>k){
                Integer poll = minHeap.poll();
                hashSet.remove(poll);
            }
        }

        return minHeap.peek();
    }
}
