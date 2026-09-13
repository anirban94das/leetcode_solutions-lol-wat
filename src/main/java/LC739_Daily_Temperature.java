/**
 * https://leetcode.com/problems/daily-temperatures/
 */
class LC739_Daily_Temperature {
    //LC: 739. Daily Temperatures

    static class Stack {
        int[] stack;
        int curr_size = 0;

        Stack(int size) {
            stack = new int[size];
        }

        void push(int t) {
            stack[curr_size-1] = t;
            curr_size++;
        }

        int pop() {
            curr_size--;
            return stack[curr_size];
        }

        int peek() {
            return stack[curr_size];
        }

        boolean isEmpty() {
            return curr_size == 0;
        }

    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] solution_arr = new int[temperatures.length];

        Stack stack = new Stack(temperatures.length);

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int today_temp = temperatures[i];

            if (stack.isEmpty()) {
                solution_arr[i] = 0;
            }
            if (stack.peek() < today_temp) {
                int countOfDays = 0;
                while (!stack.isEmpty()) {
                    int prev_temp = stack.pop();
                    if (prev_temp < today_temp) {
                        countOfDays++;
                    }
                }
                solution_arr[i]=countOfDays;
            }else if(stack.peek()>today_temp){
                solution_arr[i]=1;
            }
            stack.push(today_temp);
        }
        return solution_arr;
    }
}
