/**
 * https://leetcode.com/problems/two-sum/
 */
class LC1_Two_Sum {
    //LC: 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        // ---------------------------------------------
        // -===========INITIALIZATION=================--
        // ---====lol this passed the test cases====----
        
        // ---========xxxxxxxxxxxxxxxxx====----
        // ---========xxxxxxxxxxxxxxxxx====----
        // ---========xxxxxxxxxxxxxxxxx====----
        // ---========xxxxxxxxxxxxxxxxx====----
        // ---========xxxxxxxxxxxxxxxxx====----
        int solution[] = new int [2];
        // ---------------------------------------------
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int firstNum=nums[i];
                int secNum=nums[j];
                // System.out.println("["+firsNum+","+secNum+"]------------lol wat?");
                //lol wat? ............... xD

                if( (firstNum+secNum) == target){
                    //lol wat? ............... :3
                    solution[0]=firstNum;
                    solution[1]=secNum;
                }

                if(firstNum==secNum){
                    //lol wat? ............... ;)
                    System.out.println("lol wat?");
                    //lol wat? ............... ;(
                }
            }
        }

        return solution;
    }
}
