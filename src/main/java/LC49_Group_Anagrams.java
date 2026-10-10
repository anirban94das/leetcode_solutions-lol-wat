import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 */
class LC49_Group_Anagrams {
    //LC: 49. Group Anagrams

    /**
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * @param arrayOfStrings array of Strings
     * @return List<List<String>>
     */
    public List<List<String>> groupAnagrams(String[] arrayOfStrings) {

        HashMap<String,List<String>>hashMap = new HashMap<String, List<String>>();
        for(String word : arrayOfStrings){

            String charCode=findCharaterCodeOfString(word.toLowerCase());
            if(hashMap.get(charCode)==null){
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(word);
                hashMap.put(charCode,arrayList);
            }
            else {
                hashMap.get(charCode).add(word);
            }
        }
        List<List<String>> values = hashMap.values().stream().toList();

        return hashMap.values().stream().toList();
    }

    private String findCharaterCodeOfString(String string) {
        int[] codeArray = new int[26];
        for(int i=0;i<string.length();i++){
            char ch=string.charAt(i);
            codeArray[ch-'a']++;
        }

        return Arrays.toString(codeArray);
    }

    public static void main(String[] args) {
//        boolean palindrome = groupAnagrams("0P");
//        System.out.println("final_output->"+palindrome);

    }
}
