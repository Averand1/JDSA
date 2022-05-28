package BinarySearch;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        int index = -1;
        while(lowIndex<=highIndex) {
            int midIndex = (lowIndex + highIndex)/2;
            if(target == arr[midIndex]) {
                index = midIndex;
                break;
            }
            else if(target < highIndex) {
                highIndex = midIndex - 1;
            }
            else if(target > lowIndex) {
                lowIndex = midIndex + 1;
            }
        }
        return index;

    }
    
    public static void main(String args[]) {
        int arr[] = {21,32,42,23,54,53,95};
        System.out.println("The index of target is " + binarySearch(arr, 53));
        
    }
    
}
