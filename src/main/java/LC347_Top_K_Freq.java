import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class LC347_Top_K_Freq {
    //LC: 347. Top K Freq Elements
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> countMap=new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if((o1.count > o2.count)){
                    return 1;
                }
                else if (o1.count == o2.count){
                    return 0;
                }else
                    return -1;
            }
        });


        for (int i:nums) {
            if(countMap.containsKey(i)){
                countMap.compute(i, (key, count) -> (count + 1));
            }else{
                countMap.put(i,1);
            }
            minHeap.offer(new Pair(i, countMap.get(i)));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int arr[]=new int[k];
        for(int i=0;i< k;i++){
            arr[i]= minHeap.poll().key;
        }

        return arr;
    }

    class Pair{
        public int key;
        public int count;

        Pair(int k, int c){
            key=k;
            count=c;
        }
    }

}
