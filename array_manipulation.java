/**
 * Project 7. Array manipulation.
 * Randomizes int array and prints the array
 * Prints largest, smallest, range, and average.
 * Asks user to select a value to find in the array.
 * Sorts the array and prints the array.
 * 
 * Alex Hampton
 * 03/18/2021
 */

import java.util.Scanner;

public class AlexHamptonProject07 {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        int search_value;
        int found_index;
        
        // Declare int array of size 10.
        int[] list = new int[10];
        // Call initializeArray function
        initializeArray(list); 
        // call printArray function
        System.out.println("Random Array:");
        printArray(list); 
        // print largest and smallest values
        System.out.println("\nLargest: " + largest(list) + 
                            "\tSmallest: " + smallest(list));
        // print range and average values     
        System.out.println("Range: " + range(list) +
                            "\tAverage: " + average(list) + "\n");
        
        // ask user to enter a search key
        System.out.print("Please enter a value to search for: ");
        search_value = user_input.nextInt();
        System.out.println("Value entered: " + search_value);
        
        // call linearSearch function, print out appropriate message.
        found_index = linearSearch(list, search_value);
        if (found_index == -1) {
            System.out.println("The value you entered was not found.");
        }
        else {
            System.out.println("The value is located at index " + found_index);
        }
        
        // call the selectSort function
        selectSort(list);
        
        // print sorted list
        System.out.println("\nThe list has now been sorted:");        
        printArray(list);
        
        System.out.println("\n\n");
    }
    
    // returns index in arr where key is found.
    // returns -1 if key is not found in arr
    public static int linearSearch(int arr[], int key) {
        for(int i =0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }
    
    // sorts arr from smallest to largest using select sort algorithm
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (j > i && arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    // prints all array elements, 5 elements per line
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d ", arr[i]);
            if ((i + 1) % 5 == 0)
                System.out.println();
        }
    }
    
    // assign each element in array with a random number
    // between 1 and 100, inclusive
    public static void initializeArray(int arr[]) {
        int randomNumber;
        for(int i = 0; i < arr.length; i++) {
            randomNumber = (int)(1 + Math.random() * 100);
            arr[i] = randomNumber;
        }
    }
    
    // find the range of all array elements
    public static int range(int arr[]) {
        return (largest(arr) - smallest(arr));
    }
    
    // find the largest element in array
    public static int largest(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    
    // find the smallest element in array
    public static int smallest(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < min) min = arr[i];
        return min;
    }
    
    // find the average value of all elements in array
    public static double average(int arr[]) {
        double total = 0.0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total / arr.length;
    }
}



// OUTPUT

// Random Array:
// 71  79  31   4  11 
// 11  83  86  58  21 

// Largest: 86	Smallest: 4
// Range: 82	Average: 45.5

// Please enter a value to search for: 86
// Value entered: 86
// The value is located at index 7

// The list has now been sorted:
// 4  11  11  21  31 
// 58  71  79  83  86 



// Random Array:
// 13   3   5  32  97 
// 38  19  19  29  29 

// Largest: 97	Smallest: 3
// Range: 94	Average: 28.4

// Please enter a value to search for: 1
// Value entered: 1
// The value you entered was not found.

// The list has now been sorted:
// 3   5  13  19  19 
// 29  29  32  38  97 