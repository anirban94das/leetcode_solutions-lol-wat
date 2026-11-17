import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/insert-interval/description/
 */
class LC981_Time_Based_KV_Store {
    //LC: 981. Time Based Key-Value Store

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */

    //LC 981 in Java

    class TimeMap {

        Map<String, TreeMap<Integer, String>> map;


        public TimeMap() {
             map = new ConcurrentHashMap<String, TreeMap<Integer, String>>();
        }

        public void set(String key, String value, int timestamp) {

            if(!map.containsKey(key)){
                TreeMap<Integer, String> treeMap = new TreeMap<>();
                treeMap.put(timestamp,value);
                map.put(key,treeMap);
            }else{
                TreeMap<Integer, String> timeStampTreeMap = map.get(key);
                timeStampTreeMap.put(timestamp,value);
            }
        }

        public String get(String key, int timestamp) {
            return  get_Via_TreeMap(key, timestamp);
//            return  get_Via_Binary_Search(key, timestamp);
        }

        public String get_Via_TreeMap(String key, int timestamp) {
            if(map.containsKey(key)){
                TreeMap<Integer, String> timeStampTreeMap = map.get(key);
                Map.Entry<Integer, String> integerStringEntry = timeStampTreeMap.floorEntry(timestamp);
                if(integerStringEntry!=null){
                    return integerStringEntry.getValue();
                }
            }
            return "";

        }

        public String get_Via_Binary_Search(String key, int timestamp) {
            if(map.containsKey(key)){
                TreeMap<Integer, String> timeStampTreeMap = map.get(key);
//                Map.Entry<Integer, String> integerStringEntry = timeStampTreeMap.floorEntry(timestamp);

                ArrayList<Integer> arrayListOfTimeStamps = timeStampTreeMap.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
                int low=0;
                int high=arrayListOfTimeStamps.size()-1;
                int mid=0;
                while(low>=high){
                    int low_timestamp=arrayListOfTimeStamps.get(low);
                    int high_timestamp=arrayListOfTimeStamps.get(high);
                    mid=(low+high)/2;
                    int mid_timestamp = arrayListOfTimeStamps.get(mid);

                    if(mid_timestamp>)

                }



            }
            return "";
        }
    }
}




