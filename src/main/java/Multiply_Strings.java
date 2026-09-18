public class Multiply_Strings {


    //num1 -> 23465
    //num2 -> 6352
    // A-Z->65-90
    public static String multiply(String num1, String num2) {

        char[] charArray1 = num1.toCharArray();
        char[] charArray2 = num2.toCharArray();

        long product=0;
        long sum=0;
        for(int i=0;i< charArray1.length;i++){
            int n1=(int)(charArray1[i] - '0');
//            System.out.println("n1->"+n1);
            sum=0;
            for(int j=0;j<charArray2.length;j++){
                sum*=10;
                int n2=(int)(charArray2[j] - '0');
//                System.out.println("n2->"+n2);
                sum+=n1*n2;
//                System.out.println("sum->"+sum);
            }
            product=10*product+sum;
//            System.out.println("product->"+product);
        }
        return String.valueOf(product);
    }
    public static void main(String args[]){
        String multiply = multiply("123", "456");
        System.out.println(multiply);
    }
}
