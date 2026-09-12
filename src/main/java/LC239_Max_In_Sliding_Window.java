/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
class LC239_Max_In_Sliding_Window {
    //LC: 76. Minimum Window Substring
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int solution_arr[] = new int[n - k + 1];

        if (k == 1) {
            return nums;
        }
        int c = 0;
        int local_max = nums[0];
        int left = 0;
        int right = k - 1;

        // local_max has the max value in the array.
        local_max = find_max(nums, 0, k - 1);
        int count = 0;
        solution_arr[0] = local_max;
        count++;
        for (int i = k; i < n; i++) {
            // System.out.println("i->"+i+"|n ->"+n+"|local_max ->"+local_max+"|nums[i]->"+nums[i]+"|nums[i - k ]->"+nums[i - k ]+"|count->"+count);
            if (nums[i] > local_max) {
                local_max = nums[i];
            } else if (nums[i - k] >= local_max) {
                // System.out.println("find_max getting triggered.")
                local_max = find_max(nums, i - k + 1, i);
            }
            solution_arr[count] = local_max;
            count++;
        }
        return solution_arr;
    }

    static int find_max(int arr[], int start, int end) {
        int local_max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] >= local_max) {
                local_max = arr[i];
            }
        }
        return local_max;
    }
}
