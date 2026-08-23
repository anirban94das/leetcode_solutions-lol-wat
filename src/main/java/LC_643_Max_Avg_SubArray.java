/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
class LC_643_Max_Avg_SubArray {

    public static void main(String args[]) {

    }

    public double findMaxAverage(int[] nums, int k) {
        // Integer.parseInt("");
        int sum = 0;

        // System.out.println("=====================================================");
        for (int j = 0; j < k; j++) {
            sum += nums[j];
            // System.out.print(nums[j]+",");
        }
        System.out.println();
        // System.out.println("=====================================================");
        // double currentWindowSum = ((double) sum / k);
        double currentWindowSum = sum;
        // double maxSum = (double) -1;
        double maxSum = currentWindowSum;
        // System.out.println("currentWindowSum->" + sum);
        // System.out.println("=====================================================");
        for (int i = 0; i < nums.length - k; i++) {
            int leftPeek = i;
            int rightPeek = i + k;
            double newSum = currentWindowSum + nums[rightPeek] - nums[leftPeek];
            // System.out.println("=====================================================");
            // System.out.println("currentWindowSum + nums[rightPeek] - nums[leftPeek]");
            // System.out.println(currentWindowSum+";"+nums[rightPeek]+";"+nums[leftPeek]);
            // System.out.println("newSum->" + newSum);
            // System.out.println("=====================================================");

            currentWindowSum = newSum;
            if (newSum > maxSum) {
                maxSum = newSum;
            }
            currentWindowSum = newSum;
        }
        return ((double) maxSum / k);
    }
}