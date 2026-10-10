/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
class LC125_Valid_Palindrome {
    //LC: 125. Valid Palindrome
    public static boolean isPalindrome(String s) {

        System.out.println("input_String->"+s);

        String lowerCaseInputString=s.toLowerCase();
        System.out.println("lowerCaseInputString->"+lowerCaseInputString);
        StringBuilder sanitizedStringBuilder = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch=lowerCaseInputString.charAt(i);
            if((ch>= 'a')&&(ch<='z')||(ch>='0')&&(ch<='9')){
                sanitizedStringBuilder.append(ch);
            }
        }//string is sanitized after this.
        String santizedString=sanitizedStringBuilder.toString();
        System.out.println("santizedString->"+santizedString);

        int left=0;int right=santizedString.length()-1;
        char[] charArray = santizedString.toCharArray();
        while (left<right){

            char left_char=charArray[left];
            char right_char=charArray[right];
            System.out.println("left_char->"+left_char);
            System.out.println("right_char->"+right_char);

            if(left_char !=right_char){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("0P");
        System.out.println("final_output->"+palindrome);

    }
}
