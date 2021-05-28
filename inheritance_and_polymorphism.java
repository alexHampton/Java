/**
 * Project 11: Inheritance and Polymorphism.
 * Creates and Account array and uses
 * Polymorphism to set the elements to
 * inherited classes CheckingAccount
 * and SavingsAccount.
 * 
 * 
 * Author: Alex Hampton
 * 04/28/2021
 */

public class AlexHamptonProj11 {
    
    public static void main(String[] args) {
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
        
        accounts[0].deposit(500);
        System.out.println("\nAfter depositing 500:\n");
        System.out.println(accounts[0]);
        
        accounts[0].withdraw(2000);
        System.out.println("\nAfter attempting to withdraw 2000:\n");
        System.out.println(accounts[0]);
        
        accounts[0].withdraw(200);
        System.out.println("\nAfter attempting to withdraw 200:\n");
        System.out.println(accounts[0]);        
        System.out.println("\n");
        
        
        
        
        // Test Array[1] Checking Account        
        System.out.println("****************************");
        System.out.println("     Account " + accounts[1].getId());
        System.out.println("****************************");
        System.out.println(accounts[1]);
        
        accounts[1].deposit(500);
        System.out.println("\nAfter depositing 500:\n");
        System.out.println(accounts[1]);
        
        accounts[1].withdraw(-5000);
        System.out.println("\nAfter attempting to withdraw -5000:\n");
        System.out.println(accounts[1]);
        
        accounts[1].withdraw(200);
        System.out.println("\nAfter attempting to withdraw 200:\n");
        System.out.println(accounts[1]);        
        System.out.println("\n");
        
        
        
        // Test Array[2] Savings Account
        System.out.println("****************************");
        System.out.println("     Account " + accounts[2].getId());
        System.out.println("****************************");
        System.out.println(accounts[2]);
        
        accounts[2].deposit(500);
        System.out.println("\nAfter depositing 500:\n");
        System.out.println(accounts[2]);
        
        accounts[2].withdraw(500000);
        System.out.println("\nAfter attempting to withdraw 500000:\n");
        System.out.println(accounts[2]);
        
        accounts[2].withdraw(200);
        System.out.println("\nAfter attempting to withdraw 200:\n");
        System.out.println(accounts[2]);        
        System.out.println("\n");
        
        // Explicit Cast to Savings Account
        if(accounts[2] instanceof SavingsAccount) {           
            ((SavingsAccount)accounts[2]).addInterest();
        }        
        System.out.println("After adding interest:\n");
        System.out.println(accounts[2]);        
        System.out.println("\n");
        
        
        
        
        // Test Array[3] Savings Account
        System.out.println("****************************");
        System.out.println("     Account " + accounts[3].getId());
        System.out.println("****************************");
        System.out.println(accounts[3]);
        
        accounts[3].deposit(500);
        System.out.println("\nAfter depositing 500:\n");
        System.out.println(accounts[3]);
        
        accounts[3].withdraw(-5000);
        System.out.println("\nAfter attempting to withdraw -5000:\n");
        System.out.println(accounts[3]);
        
        accounts[3].withdraw(200);
        System.out.println("\nAfter attempting to withdraw 200:\n");
        System.out.println(accounts[3]);        
        System.out.println("\n");
        
        // Explicit Cast to SavingsAccount
        if(accounts[3] instanceof SavingsAccount) {           
            ((SavingsAccount)accounts[3]).addInterest();
        }        
        System.out.println("\nAfter adding interest:\n");
        System.out.println(accounts[3]);        
        System.out.println("\n");
            
        
    }
    
    
}

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
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        
    }
    
    @Override // from java.lang.Object
    public String toString() {
        return String.format("ID: %3d Balance: %9.2f", id, balance);
    }
}

class CheckingAccount extends Account {
    
    public CheckingAccount() {
        super();
    }
    
    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if (amount > 0 && amount <= currentBalance) {
            setBalance(currentBalance - amount);
        }
    }
    
    @Override
    public String toString() {
        return "This is a Checking Account. " + super.toString();
    }
}

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
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if (amount > 0 && currentBalance - amount >= 500) {
            setBalance(currentBalance - amount);
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


/**************************************************
 *             OUTPUT
 **************************************************/


// ****************************
     // Account 1
// ****************************
// This is a Checking Account. ID:   1 Balance:      0.00

// After depositing 500:

// This is a Checking Account. ID:   1 Balance:    500.00

// After attempting to withdraw 2000:

// This is a Checking Account. ID:   1 Balance:    500.00

// After attempting to withdraw 200:

// This is a Checking Account. ID:   1 Balance:    300.00


// ****************************
     // Account 2
// ****************************
// This is a Checking Account. ID:   2 Balance:   5000.00

// After depositing 500:

// This is a Checking Account. ID:   2 Balance:   5500.00

// After attempting to withdraw -5000:

// This is a Checking Account. ID:   2 Balance:   5500.00

// After attempting to withdraw 200:

// This is a Checking Account. ID:   2 Balance:   5300.00


// ****************************
     // Account 3
// ****************************
// This is a Savings Account. ID:   3 Balance:  10000.00
// The interest rate is 0.05

// After depositing 500:

// This is a Savings Account. ID:   3 Balance:  10500.00
// The interest rate is 0.05

// After attempting to withdraw 500000:

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

// After depositing 500:

// This is a Savings Account. ID:   4 Balance:   2500.00
// The interest rate is 0.08

// After attempting to withdraw -5000:

// This is a Savings Account. ID:   4 Balance:   2500.00
// The interest rate is 0.08

// After attempting to withdraw 200:

// This is a Savings Account. ID:   4 Balance:   2300.00
// The interest rate is 0.08



// After adding interest:

// This is a Savings Account. ID:   4 Balance:   2484.00
// The interest rate is 0.08


