import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
class LC_242_Valid_Anagram {


    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }
        if(s==null&&t!=null){
            return false;
        }
        if(s!=null&&t==null){
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        s=s.toLowerCase();
        t=t.toLowerCase();

        int[] charMapS = new int[26];
        int[] charMapT = new int[26];
        for (int i = 0; i < s.length(); i++) {

            char chatAtS=s.charAt(i);
            char chatAtT=t.charAt(i);

//            System.out.println("=====================================================");
//            System.out.println("chatAtS->"+chatAtS);
//            System.out.println("chatAtT->"+chatAtT);
//            System.out.println("=====================================================");

            int indexS=(int)chatAtS - 'a';
            int indexT=(int)chatAtT - 'a';

//            System.out.println("=====================================================");
//            System.out.println("(int)chatAtS->"+(int)chatAtS);
//            System.out.println("(int)chatAtT->"+(int)chatAtT);
//            System.out.println("=====================================================");
//            System.out.println("=====================================================");
//            System.out.println("indexS->"+indexS);
//            System.out.println("indexT->"+indexT);
//            System.out.println("=====================================================");

            charMapS[indexS]++;
            charMapT[indexT]++;
        }
        for (int i = 0; i < s.length(); i++) {
           if(charMapS[i]!=charMapT[i]){
               return false;
           }
        }
        return true;
    }
}