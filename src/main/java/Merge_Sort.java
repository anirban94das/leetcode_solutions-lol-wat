//input: 1:[2,3,4,6] 2:[1,5,7,8,9,10]
//output: [1,2,3,4,5,6,7,8,9,10]
public class Merge_Sort {
void main(String args[]){
    int[] arr1={2,3,4,6};
    int[] arr2={1,5,7,8,9,10};
    int[] sol=mergeSortedArray(arr1,arr2);
    for(int i=0;i< sol.length;i++)
    {
        System.out.print(sol[i]+",");
    }
}
    int[] mergeSortedArray(int[] arr1, int[] arr2) {

        int size1 = arr1.length;
        int size2 = arr2.length;
        int[] solutionArray = new int[size1 + size2];

        int counter1 = 0;
        int counter2 = 0;
        int solution_counter = 0;
        while (counter1 < size1 && counter2 < size2) {
            if (arr1[counter1] > arr2[counter2]) {
                solutionArray[solution_counter] = arr2[counter2];
                solution_counter++;
                counter2++;
            } else if (arr1[counter1] < arr2[counter2]) {
                solutionArray[solution_counter] = arr1[counter1];
                solution_counter++;
                counter1++;
            }else if(arr1[counter1] == arr2[counter2]){
                solutionArray[solution_counter] = arr2[counter2];
                solution_counter++;
                solutionArray[solution_counter] = arr1[counter1];
                solution_counter++;
                counter1++;
                counter2++;
            }
        }
        while(counter1<size1){
            solutionArray[solution_counter] = arr1[counter1];
            solution_counter++;
            counter1++;
        }
        while(counter2<size2){
            solutionArray[solution_counter] = arr2[counter2];
            solution_counter++;
            counter2++;
        }
        return solutionArray;
    }


}
