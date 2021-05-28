
/**
 * Mortgage rate calculator
 * Asks user for principle amount owed, initerest rate in decimal,
 * and number of years.
 * Prints a table of the (1) month, (2) monthly payment,
 * (3) monthly interest, (4) monthly principle, 
 * (5) total interest paid, and (6) balance.
 *
 * Alex Hampton
 * 03/02/2021
 */
import java.util.Scanner;

public class AlexHamptonProject05 {
    public static void main(String[] args) {
        // declare variables
        Scanner input = new Scanner(System.in);
        double principle, current_balance;
        double interestRate;
        int term;
        int months;
        double monthlyPayment;
        double current_interest;
        double current_paydown;
        char goAgain = 'y';
        
        /****************************************
         *      do while loop                   *
         ****************************************/
        // do while loop that takes sentinel value 'y' or 'Y' to 
        // continusously ask user for new input.
        do {
            
            // These variables reset to zero in case user wants program to loop.
            int current_month = 0;
            double total_interest = 0;
            
            
            // Get user input (principle, interestRate, term in years)
            System.out.print("Enter the principle to borrow: ");
            principle = input.nextDouble();
            current_balance = principle;
            System.out.print("Enter the interestRate in decimal: ");
            interestRate = input.nextDouble();
            System.out.print("Enter the term (in years): ");
            
            term = input.nextInt();
            months = term * 12;
            monthlyPayment = monthlyPayment(principle, months, interestRate);        
            
            // Print table header
            System.out.printf("%6s%12s%16s%16s%20s%10s\n\n", 
                "Month", "Payment", "Interest", 
                "Principle", "Total Interest", "Balance");
            
            
            /****************************************
             *      for loop                        *
             ****************************************/
            
            for (current_month = 1; current_month <= months; current_month++) {
                double new_balance = new_bal(principle, current_month, interestRate, monthlyPayment); // create new balance for the month
                current_interest = monthlyPayment - (current_balance - new_balance); // determine interest paid for the month
                current_paydown = monthlyPayment - current_interest; // determine principle paid for the month
                total_interest += current_interest;
                
                System.out.printf("%6d%5s%9.2f%6s%8.2f%7s%9.2f%6s%9.2f%8s%11.2f\n", 
                    current_month, "$", monthlyPayment, "$", current_interest, 
                    "$", current_paydown, "$", total_interest, 
                    "$", new_balance);
                current_balance = new_balance;            
            }
            
            
            /****************************************
             *      while loop                      *
             ****************************************/
            
            // current_month = 1;
            // while (current_month <= months) {
                // double new_balance = new_bal(principle, current_month, interestRate, monthlyPayment); // create new monthly balance
                // current_interest = monthlyPayment - (current_balance - new_balance); // determine interest paid for the month
                // current_paydown = monthlyPayment - current_interest; // determine principle paid for the month
                // total_interest += current_interest;
                
                // System.out.printf("%6d%5s%9.2f%6s%8.2f%7s%9.2f%6s%9.2f%8s%11.2f\n", 
                    // current_month, "$", monthlyPayment, "$", current_interest, 
                    // "$", current_paydown, "$", total_interest, 
                    // "$", new_balance);
                // current_balance = new_balance;
                
                // current_month++;
            // }
            
            
            // Ask for user input and read in sentinel value.
            System.out.print("Would you like to go again? (y/n): ");
            goAgain = input.next().charAt(0);
            
        } while (goAgain == 'Y' || goAgain == 'y');
        
        
    }
    
    // Takes in (p)rinciple, (n)umber of months, (i)nterest_rate
    // Returns the monthly payment.
    public static double monthlyPayment(double p, int n, double i) {
        double r = i / 12; // (r)ate for the month
        
        double top = p * r * Math.pow((1 + r), n);
        double bottom = Math.pow((1 + r), n) - 1;
        
        return top / bottom;
    }
    
    // Takes in (p)rinciple, current month (n)umber, (i)nterest rate, and (m)onthly payment
    // Returns the new value after the principle has been paid down.
    public static double new_bal(double p, int n, double i, double m) {
        double r = i / 12;
        double first_part = Math.pow((1 + r), n) * p;
        double top = (Math.pow((1 + r), n) - 1) * m;
        double frac = top / r;
        return (first_part - frac);
    }
}



/****************************************
 *      OUTPUT                          *
 ****************************************/

// Enter the principle to borrow: 50000
// Enter the interestRate in decimal: 0.05
// Enter the term (in years): 2
 // Month     Payment        Interest       Principle      Total Interest   Balance

     // 1    $  2193.57     $  208.33      $  1985.24     $   208.33       $   48014.76
     // 2    $  2193.57     $  200.06      $  1993.51     $   408.39       $   46021.26
     // 3    $  2193.57     $  191.76      $  2001.81     $   600.15       $   44019.44
     // 4    $  2193.57     $  183.41      $  2010.16     $   783.56       $   42009.29
     // 5    $  2193.57     $  175.04      $  2018.53     $   958.60       $   39990.76
     // 6    $  2193.57     $  166.63      $  2026.94     $  1125.23       $   37963.81
     // 7    $  2193.57     $  158.18      $  2035.39     $  1283.41       $   35928.43
     // 8    $  2193.57     $  149.70      $  2043.87     $  1433.12       $   33884.56
     // 9    $  2193.57     $  141.19      $  2052.38     $  1574.30       $   31832.18
    // 10    $  2193.57     $  132.63      $  2060.94     $  1706.94       $   29771.24
    // 11    $  2193.57     $  124.05      $  2069.52     $  1830.98       $   27701.72
    // 12    $  2193.57     $  115.42      $  2078.15     $  1946.41       $   25623.57
    // 13    $  2193.57     $  106.76      $  2086.80     $  2053.17       $   23536.77
    // 14    $  2193.57     $   98.07      $  2095.50     $  2151.24       $   21441.27
    // 15    $  2193.57     $   89.34      $  2104.23     $  2240.58       $   19337.04
    // 16    $  2193.57     $   80.57      $  2113.00     $  2321.15       $   17224.04
    // 17    $  2193.57     $   71.77      $  2121.80     $  2392.92       $   15102.24
    // 18    $  2193.57     $   62.93      $  2130.64     $  2455.84       $   12971.59
    // 19    $  2193.57     $   54.05      $  2139.52     $  2509.89       $   10832.07
    // 20    $  2193.57     $   45.13      $  2148.44     $  2555.03       $    8683.64
    // 21    $  2193.57     $   36.18      $  2157.39     $  2591.21       $    6526.25
    // 22    $  2193.57     $   27.19      $  2166.38     $  2618.40       $    4359.87
    // 23    $  2193.57     $   18.17      $  2175.40     $  2636.57       $    2184.47
    // 24    $  2193.57     $    9.10      $  2184.47     $  2645.67       $      -0.00
// Would you like to go again? (y/n): y
// Enter the principle to borrow: 100000
// Enter the interestRate in decimal: 0.025
// Enter the term (in years): 1
 // Month     Payment        Interest       Principle      Total Interest   Balance

     // 1    $  8446.61     $  208.33      $  8238.28     $   208.33       $   91761.72
     // 2    $  8446.61     $  191.17      $  8255.44     $   399.50       $   83506.28
     // 3    $  8446.61     $  173.97      $  8272.64     $   573.48       $   75233.64
     // 4    $  8446.61     $  156.74      $  8289.87     $   730.21       $   66943.77
     // 5    $  8446.61     $  139.47      $  8307.14     $   869.68       $   58636.62
     // 6    $  8446.61     $  122.16      $  8324.45     $   991.84       $   50312.17
     // 7    $  8446.61     $  104.82      $  8341.79     $  1096.65       $   41970.38
     // 8    $  8446.61     $   87.44      $  8359.17     $  1184.09       $   33611.20
     // 9    $  8446.61     $   70.02      $  8376.59     $  1254.12       $   25234.62
    // 10    $  8446.61     $   52.57      $  8394.04     $  1306.69       $   16840.58
    // 11    $  8446.61     $   35.08      $  8411.53     $  1341.77       $    8429.05
    // 12    $  8446.61     $   17.56      $  8429.05     $  1359.33       $      -0.00
// Would you like to go again? (y/n): n


