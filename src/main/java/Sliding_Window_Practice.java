import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Sliding_Window_Practice {
    // Returns maximum sum in
    // a subarray of size k.
    static int maxSum(int arr[], int n, int k){
        // Initialize result
        int max_sum = Integer.MIN_VALUE;

        // Consider all blocks starting with i.
        for (int i = 0; i < n - k + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < k; j++)
                current_sum = current_sum + arr[i + j];

            // Update result if required.
            max_sum = Math.max(current_sum, max_sum);
        }

        return max_sum;
    }


    static int maxLength_Unique_Char_String_dynamic_sliding_window(String str) {
        // Initialize result
        int max_length = 0;

        HashSet<Character> characterHashSet = new HashSet<>();
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
//            System.out.println("char ->"+c);
            if (!characterHashSet.contains(c)) {
                characterHashSet.add(c);
                end++;
            } else {
                characterHashSet.clear();
                start=end-1;
            }
            System.out.println("char ->"+c+"|start ->"+start+"|end->"+end+"|max_length->"+max_length);

            if ((end - start) > max_length) {
                max_length = (end - start);
            }
            System.out.println("max_length ->"+max_length);
            print_the_subString(str,start,end);
        }
        return max_length;
    }
    static void print_the_subString(String str, int start, int end){
        char[] charArray = str.toCharArray();
        for (int i = start; i <= end; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();
    }

    static int maxLength_Unique_Char_String_dynamic_sliding_window_v2(String str) {
        // Initialize result
        int max_length = 0;

        HashSet<Character> characterHashSet = new HashSet<>();
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = 0;
        while (end<str.length()){

        }
        return max_length;
    }

    public String minWindow(String s, String t) {

        if(s==null||t==null){
            return "";
        }
        if(s.length()<t.length()){
            return "";
        }
        if(s.equalsIgnoreCase(t)){
           return t;
        }

        return "";
    }

    static int maxSum_V2_fixed_sliding_window(int arr[], int n, int k){
        // Initialize result
        int max_sum = Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<k;i++){
            sum+=arr[i];
        }

        for(int i=k;i<n;i++){
            sum+=arr[i];
            sum-=arr[i-k];
            max_sum=Math.max(sum,max_sum);
        }

        return max_sum;
    }

    public static void main(String[] args){
        int arr[] = {5, 2, -1, 0, 3};
        int k = 3;
        int n = arr.length;
        System.out.println(maxSum_V2_fixed_sliding_window(arr, n, k));
        System.out.println(maxLength_Unique_Char_String_dynamic_sliding_window("abcddafecd"));
    }
}

