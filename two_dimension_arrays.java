
/**
 * Project 8: User inputs a number between 0 and 511, inclusively.
 * Print out a 3x3 array representing (H)eads and (T)ails depending
 * on the number they select.
 * Ex. 0 represents all (H)eads because 0 correlates to 000000000
 *          H H H
 *          H H H
 *          H H H          
 *     511 represents all (T)ails because 511 correlates to 111111111
 *          T T T
 *          T T T
 *          T T T
 *     152  correlates to 010 011 000. 0's are Heads, 1's are Tails, so
 *          H T H
 *          H T T
 *          H H H
 *          
 * Alex Hampton
 * 03/25/2021
 */

import java.util.Scanner;

public class AlexHamptonProject08 {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        char goAgain = 'y';
        while (goAgain == 'y' || goAgain == 'Y') { // loop if user wants to try multiple numbers
            int num;
            int[][] matrix;
            
            // Explain the program
            printHeader();
            // Get and validate user input.
            num = validateNumber(user_input);
            System.out.println();
            // Update array with binary form of the number
            matrix = setBinaryMatrix(num);
            // Print out 3 x 3 grid representing Heads and Tails.
            printMatrix(matrix);
            System.out.println();
            
            System.out.print("Go again? (y/n): ");
            goAgain = user_input.next().charAt(0);
            System.out.println();
        }
    }
    
    // print header
    public static void printHeader() {
        System.out.println("There are 512 differrent combinations of\n" +
                "Heads and Tails if you flip a coin 9 times.\n" +
                "____________________________________________");
    }
    
    // takes in a Scanner and returns a validated number 
    // given by the user
    public static int validateNumber(Scanner user_input) {
        int num;
        do {
            System.out.print("Enter an integer representing the state\n" +
            "of coins (between 0 and 511, inclusively): ");
            num = user_input.nextInt();
            if (num < 0 || num > 511) {
                System.out.println("****************************************");
                System.out.println("Error: Number must be between 0 and 511.");
                System.out.println("****************************************\n\n");
            }
        } while (num < 0 || num > 511);
        return num;
    }
    
    // Precondition: Num must be between 0 and 511, inclusively.
    // returns a 3 x 3 matrix representing the binary form of the number.
    public static int[][] setBinaryMatrix(int num) {
        
        int[][] matrix = new int[3][3];
        int x = 2, y = 2;
        int bit;
        
        // convert to binary and place in matrix
        while (num > 0) {
            bit = num % 2;                                          // while number is greater than zero
            // place bit at the end of the matrix.                  // mod number, and put the answer to
            matrix[x][y] = bit;                                     // the mod into the end of the array            
            num /= 2;                                               // divide the number by 2
            
            // move to the next array position.
            if (y == 0) { // if we finished a row
                x--; // move to the end of the row above
                y = 2;
            }
            else { // move to the next column
                y--;
            }
            
            // once this is finished, any leading zeros will already be part of
            // the front of the array because declared int arrays are initialized
            // to zero.
        }
        
        return matrix;
    }
    
    // takes in an 2-dimensional array and prints
    // 'H' for 0's, 'T' for 1's.
    public static void printMatrix(int[][] arr) {
        char coinFlip;
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0)
                    coinFlip = 'H';
                else
                    coinFlip = 'T';
                System.out.print(coinFlip + " ");
            }
            
            System.out.println();
        }
    }
}


/*********************************************
 *          OUTPUT
 *********************************************/

// There are 512 differrent combinations of
// Heads and Tails if you flip a coin 9 times.
// ____________________________________________
// Enter an integer representing the state
// of coins (between 0 and 511, inclusively): -1
// ****************************************
// Error: Number must be between 0 and 511.
// ****************************************


// Enter an integer representing the state
// of coins (between 0 and 511, inclusively): 512
// ****************************************
// Error: Number must be between 0 and 511.
// ****************************************


// Enter an integer representing the state
// of coins (between 0 and 511, inclusively): 255

// H T T 
// T T T 
// T T T 

// Go again? (y/n): y

// There are 512 differrent combinations of
// Heads and Tails if you flip a coin 9 times.
// ____________________________________________
// Enter an integer representing the state
// of coins (between 0 and 511, inclusively): 107

// H H T 
// T H T 
// H T T 

// Go again? (y/n): y

// There are 512 differrent combinations of
// Heads and Tails if you flip a coin 9 times.
// ____________________________________________
// Enter an integer representing the state
// of coins (between 0 and 511, inclusively): 0

// H H H 
// H H H 
// H H H 

// Go again? (y/n): y

// There are 512 differrent combinations of
// Heads and Tails if you flip a coin 9 times.
// ____________________________________________
// Enter an integer representing the state
// of coins (between 0 and 511, inclusively): 511

// T T T 
// T T T 
// T T T 

// Go again? (y/n): n



