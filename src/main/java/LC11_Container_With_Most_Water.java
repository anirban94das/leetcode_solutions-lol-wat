/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */
class LC11_Container_With_Most_Water {
    //LC: 11. Container With Most Water
    public static int maxArea(int[] height) {

        int left=0;
        int right= height.length-1;
        int left_max=height[left];
        int right_max=height[right];
        int min_of_left_right=Integer.MIN_VALUE;
        int area_of_water=0;

        while(left<right){
            min_of_left_right=Math.min(left_max,right_max);






        }

        return 0;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int max_water = maxArea(height);
        System.out.println("final_output->"+ max_water);

    }
}
