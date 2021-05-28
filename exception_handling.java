/**
 * Project 12: Excepion Handling
 * Using Custom Exception Classes to Handle errors 
 * in Account class and derived classes.
 * Custom Exception Classes include
 * IllegalAmountException and NoSufficientFundsException
 * 
 * 
 * Author: Alex Hampton
 * 05/05/2021
 */

public class AlexHamptonProj12 {   
    /***************************************************
     *              main
     ***************************************************/
    public static void main(String[] args) 
        throws IllegalAmountException, NoSufficientFundsException { // Exception declaration
        // Create Account Array.
        Account[] accounts = new Account[4];        
        accounts[0] = new CheckingAccount();
        accounts[1] = new CheckingAccount(2, 5000);
        accounts[2] = new SavingsAccount(3, 10000, 0.05);
        accounts[3] = new SavingsAccount(4, 2000, 0.08);
        
        
        // Test Array[0] Checking account
        System.out.println("****************************");
        System.out.println("     Account " + accounts[0].getId());
        System.out.println("****************************");
        System.out.println(accounts[0]);        
        
        System.out.println("\nAfter depositing 500:\n");
        accounts[0].deposit(500);
        System.out.println(accounts[0]);
        
        System.out.println("\nAfter attempting to withdraw 2000:\n");
        accounts[0].withdraw(2000);
        System.out.println(accounts[0]);
        
        System.out.println("\nAfter attempting to withdraw 200:\n");
        accounts[0].withdraw(200);
        System.out.println(accounts[0]);        
        System.out.println("\n");
        
        
        
        
        // Test Array[1] Checking Account        
        System.out.println("****************************");
        System.out.println("     Account " + accounts[1].getId());
        System.out.println("****************************");
        System.out.println(accounts[1]);
        
        System.out.println("\nAfter attempting to deposit -500:\n");
        accounts[1].deposit(-500);
        System.out.println(accounts[1]);
        
        System.out.println("\nAfter attempting to withdraw -5000:\n");
        accounts[1].withdraw(-5000);
        System.out.println(accounts[1]);
        
        System.out.println("\nAfter attempting to withdraw 200:\n");
        accounts[1].withdraw(200);
        System.out.println(accounts[1]);        
        System.out.println("\n");
        
        
        
        
        // Test Array[2] Savings Account
        System.out.println("****************************");
        System.out.println("     Account " + accounts[2].getId());
        System.out.println("****************************");
        System.out.println(accounts[2]);
        
        System.out.println("\nAfter depositing 500:\n");
        accounts[2].deposit(500);
        System.out.println(accounts[2]);
        
        System.out.println("\nAfter attempting to withdraw 500000:\n");
        accounts[2].withdraw(500000);
        System.out.println(accounts[2]);
        
        System.out.println("\nAfter attempting to withdraw 200:\n");
        accounts[2].withdraw(200);
        System.out.println(accounts[2]);        
        System.out.println("\n");
        
        
        System.out.println("After adding interest:\n");
        // Explicit Cast to Savings Account
        if(accounts[2] instanceof SavingsAccount) {           
            ((SavingsAccount)accounts[2]).addInterest();
        }        
        System.out.println(accounts[2]);        
        System.out.println("\n");
        
        
        
        
        // Test Array[3] Savings Account
        System.out.println("****************************");
        System.out.println("     Account " + accounts[3].getId());
        System.out.println("****************************");
        System.out.println(accounts[3]);
        
        System.out.println("\nAfter attempting to deposit -500:\n");
        accounts[3].deposit(-500);
        System.out.println(accounts[3]);
        
        System.out.println("\nAfter attempting to withdraw -5000:\n");
        accounts[3].withdraw(-5000);
        System.out.println(accounts[3]);
        
        System.out.println("\nAfter attempting to withdraw 200:\n");
        accounts[3].withdraw(200);
        System.out.println(accounts[3]);        
        System.out.println("\n");
        
        
        System.out.println("\nAfter adding interest:\n");
        // Explicit Cast to SavingsAccount
        if(accounts[3] instanceof SavingsAccount) {           
            ((SavingsAccount)accounts[3]).addInterest();
        }        
        System.out.println(accounts[3]);        
        System.out.println("\n");        
    }
    
    
}

/***************************************************
*       IllegalAmountException
***************************************************/

class IllegalAmountException extends Exception {
    public IllegalAmountException() {
        super("Error: Amount must be greater than zero.");
    }
    
    public IllegalAmountException(String message) {
        super(message);
    }
    
}

/***************************************************
*       NoSufficientFundsException
***************************************************/

class NoSufficientFundsException extends Exception {
    public NoSufficientFundsException() {
        super("Error: Insufficient funds.");
    }
    
    public NoSufficientFundsException(String message) {
        super(message);
    }
}

/***************************************************
*       Account
***************************************************/
class Account {
    private int id;
    private double balance;
    
    public Account() {
        this(1, 0.0);
    }
    
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
        
    public double getBalance() {
        return balance;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void deposit(double amount) throws IllegalAmountException { // Exception declaration
        try {
            if (amount <= 0) throw new IllegalAmountException();
            balance += amount;            
        }
        catch (IllegalAmountException ex) { // Exception Handling
            System.out.println(ex.getMessage());
        }
    }
    
    public void withdraw(double amount) throws IllegalAmountException, NoSufficientFundsException{
        
    }
    
    @Override // from java.lang.Object
    public String toString() {
        return String.format("ID: %3d Balance: %9.2f", id, balance);
    }
}

/***************************************************
*       CheckingAccount
***************************************************/
class CheckingAccount extends Account {    
    public CheckingAccount() {
        super();
    }
    
    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }
    
    @Override
    public void withdraw(double amount) 
        throws IllegalAmountException, NoSufficientFundsException { // Exception declaration
        double currentBalance = getBalance();
        
        try {
            if (amount <= 0) {
                throw new IllegalAmountException();
            }
            if (amount > currentBalance) {
                throw new NoSufficientFundsException();
            }
            
            setBalance(currentBalance - amount);
        }
        catch (IllegalAmountException | NoSufficientFundsException ex) { // Exception handling
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return "This is a Checking Account. " + super.toString();
    }
}

/***************************************************
*       SavingsAccount
***************************************************/
class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount() {
        super();
        interestRate = 0.0;
    }
    
    public SavingsAccount(int id, double balance, double rate) {
        super(id, balance);
        this.interestRate = rate;
    }
    
    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    @Override
    public void withdraw(double amount) throws IllegalAmountException, NoSufficientFundsException { // Exception declaration
        double currentBalance = getBalance();
        
        try {
            
            if (amount <= 0)
                throw new IllegalAmountException();
            if (currentBalance - amount < 500)
                throw new NoSufficientFundsException();
                
            setBalance(currentBalance - amount);  
            
        }
        catch (IllegalAmountException | NoSufficientFundsException ex) { // Exception Handling
            System.out.println(ex.getMessage());
        }
              
    }
    
    public void addInterest() {
        setBalance(getBalance() * (1 + interestRate));
    }
    
    @Override
    public String toString() {
        return "This is a Savings Account. " +  super.toString() + 
            "\nThe interest rate is " + interestRate;
    }
}

/***************************************************
*       OUTPUT
***************************************************/


// ****************************
     // Account 1
// ****************************
// This is a Checking Account. ID:   1 Balance:      0.00

// After depositing 500:

// This is a Checking Account. ID:   1 Balance:    500.00

// After attempting to withdraw 2000:

// Error: Insufficient funds.
// This is a Checking Account. ID:   1 Balance:    500.00

// After attempting to withdraw 200:

// This is a Checking Account. ID:   1 Balance:    300.00


// ****************************
     // Account 2
// ****************************
// This is a Checking Account. ID:   2 Balance:   5000.00

// After attempting to deposit -500:

// Error: Amount must be greater than zero.
// This is a Checking Account. ID:   2 Balance:   5000.00

// After attempting to withdraw -5000:

// Error: Amount must be greater than zero.
// This is a Checking Account. ID:   2 Balance:   5000.00

// After attempting to withdraw 200:

// This is a Checking Account. ID:   2 Balance:   4800.00


// ****************************
     // Account 3
// ****************************
// This is a Savings Account. ID:   3 Balance:  10000.00
// The interest rate is 0.05

// After depositing 500:

// This is a Savings Account. ID:   3 Balance:  10500.00
// The interest rate is 0.05

// After attempting to withdraw 500000:

// Error: Insufficient funds.
// This is a Savings Account. ID:   3 Balance:  10500.00
// The interest rate is 0.05

// After attempting to withdraw 200:

// This is a Savings Account. ID:   3 Balance:  10300.00
// The interest rate is 0.05


// After adding interest:

// This is a Savings Account. ID:   3 Balance:  10815.00
// The interest rate is 0.05


// ****************************
     // Account 4
// ****************************
// This is a Savings Account. ID:   4 Balance:   2000.00
// The interest rate is 0.08

// After attempting to deposit -500:

// Error: Amount must be greater than zero.
// This is a Savings Account. ID:   4 Balance:   2000.00
// The interest rate is 0.08

// After attempting to withdraw -5000:

// Error: Amount must be greater than zero.
// This is a Savings Account. ID:   4 Balance:   2000.00
// The interest rate is 0.08

// After attempting to withdraw 200:

// This is a Savings Account. ID:   4 Balance:   1800.00
// The interest rate is 0.08



// After adding interest:

// This is a Savings Account. ID:   4 Balance:   1944.00
// The interest rate is 0.08


