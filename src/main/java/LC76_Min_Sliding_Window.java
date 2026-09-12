/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
class LC76_Min_Sliding_Window {
    //LC: 76. Minimum Window Substring
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
}
