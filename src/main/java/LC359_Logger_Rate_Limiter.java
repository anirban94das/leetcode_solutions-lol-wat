import java.util.*;

/**
 * https://leetcode.com/problems/logger-rate-limiter/description/
 */
class LC359_Logger_Rate_Limiter {
    //LC: 359. Logger Rate Limiter
    class Logger {
        Map<String, Integer> timeFrameMap=new LinkedHashMap<String, Integer>(16, 0.75f, true);

        public Logger() { }

        /**
         *
         * Example
         * Call	                         | Returns	Why
         * shouldPrintMessage(1, "foo")	 | true	    first “foo”, next allowed at 11
         * shouldPrintMessage(2, "bar")	 | true	    first “bar”, next allowed at 12
         * shouldPrintMessage(3, "foo")	 | false	3 < 11
         * shouldPrintMessage(8, "bar")	 | false	8 < 12
         * shouldPrintMessage(10, "foo") | false	10 < 11
         * shouldPrintMessage(11, "foo") | true	    11 ≥ 11, next allowed at 21
         *
         * @param timestamp
         * @param message
         * @return
         */
        public boolean shouldPrintMessage(int timestamp, String message) {

            if(timeFrameMap.containsKey(message)){
                //check if lastSeenTimeStamp diff >=10s
                Integer lastSeenTimeStamp = timeFrameMap.get(message);
                if(timestamp-lastSeenTimeStamp>=10){
                    timeFrameMap.put(message,timestamp);
                    return true;
                }
            }else{
                timeFrameMap.put(message,timestamp);
                return true;
            }
            // your code
            return false;
        }
    }


}
