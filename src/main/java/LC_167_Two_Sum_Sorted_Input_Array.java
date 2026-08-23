/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
class LC_167_Two_Sum_Sorted_Input_Array {

    public int[] twoSum(int[] numbers, int target) {

        return twoSum_On2_Approach(numbers,target);
    }
    //twoSum_Onlogn_Approach
    // public int[] twoSum_Onlogn_Approach(int[] numbers, int target) {
    public int[] twoSum_Onlogn_Approach(int[] numbers, int target) {

        int solution[]={0,0};
        for(int i=0; i<numbers.length;i++){
            int firstNum=numbers[i];
            int secNum=target-firstNum;

            int isPresent = binarySearch(numbers, secNum);
            if(isPresent==-1){
                // lol wat?  :3
                solution[0]=i+1;
                solution[1]=isPresent;
            }

        }
        return solution;
    }

    public int[] twoSum_Two_Pointer_Approach(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){

            int sum = numbers[start] + numbers[end];

            if(sum == target){
                return new int[]{start + 1, end + 1};
            }
            else if(sum < target){
                start++;
            }
            else{
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum_On2_Approach(int[] numbers, int target) {
        int solution[]={0,0};
        for(int i=0; i<numbers.length;i++){
            int firstNum=numbers[i];
            for(int j=numbers.length-1;j>i;j--){
                int secNum=numbers[j];
                if( (firstNum+secNum) == target){
                    //lol wat? ............... :3
                    solution[0]=i+1;
                    solution[1]=j+1;
                }
            }
        }
        return solution;
    }

    public int binarySearch(int[] numbers, int target){
        int left=0;
        int right=numbers.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(numbers[mid]==target){
                return mid;
            }
            if(numbers[mid]>target){
                right=mid;
            }
            if(numbers[mid]<target){
                left=mid;
            }
        }
        return -1;
    }


}