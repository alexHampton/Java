import java.util.*;

public class Taxes {
    
    // constant tax bracket percentages
    final static double FIRST_TIER_PERCENT = 0.10;
    final static double SECOND_TIER_PERCENT = 0.15;
    final static double THIRD_TIER_PERCENT = 0.25;
    final static double FOURTH_TIER_PERCENT = 0.28;
    final static double FIFTH_TIER_PERCENT = 0.33;
    final static double SIXTH_TIER_PERCENT = 0.35;
    
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // render menu and get tax status number.
        render_menu();
        int status = input.nextInt();
        
        // validate status input          
        if (status < 0 || status > 3) {
            System.out.println("ERROR: That is not a valid choice. Goodbye");
            return;
        }
        
        // get taxable income
        System.out.print("Enter taxable income: ");
        double income = input.nextDouble();
        
        double tax = 0;
        
        // calculate total tax based on tax status
        if (status == 0) {
            tax = calculate_income_tax(income, 0);
        }
        else if (status == 1) {
            tax = calculate_income_tax(income, 1);
        }
        else if (status == 2) {
            tax = calculate_income_tax(income, 2);
        }
        else {
            tax = calculate_income_tax(income, 3);
        }
        
        // print details
        System.out.printf("Taxable income: %8.2f\n", income);
        System.out.println("Tax status: " + status);
        System.out.printf("Your total tax is: %8.2f\n",tax);
        return;
        
    }
    
    public static double calculate_income_tax(double income, int status) {
        double tax = 0;
        double first_tier_limit;
        double second_tier_limit;
        double third_tier_limit;
        double fourth_tier_limit;
        double fifth_tier_limit;
        
        // set tax brackets based on user tax status
        if (status == 0) {
            first_tier_limit = 8350;
            second_tier_limit = 33950;
            third_tier_limit = 82250;
            fourth_tier_limit = 171550;
            fifth_tier_limit = 372950;
        }
        else if (status == 1) {
            first_tier_limit = 16700;
            second_tier_limit = 67900;
            third_tier_limit = 137050;
            fourth_tier_limit = 208850;
            fifth_tier_limit = 372950;
        }
        else if (status == 2) {
            first_tier_limit = 8350;
            second_tier_limit = 33950;
            third_tier_limit = 68525;
            fourth_tier_limit = 104425;
            fifth_tier_limit = 186475;
        }
        else {
            first_tier_limit = 11950;
            second_tier_limit = 45500;
            third_tier_limit = 117450;
            fourth_tier_limit = 190200;
            fifth_tier_limit = 372950;
        }
        
        
        
        // constants representing maximum amount of tax obtained from each tier
        final double FIRST_TIER_TAX_MAX = first_tier_limit * FIRST_TIER_PERCENT;
        final double SECOND_TIER_TAX_MAX = ((second_tier_limit 
                                            - first_tier_limit) * SECOND_TIER_PERCENT);
        final double THIRD_TIER_TAX_MAX = ((third_tier_limit 
                                            - second_tier_limit) * THIRD_TIER_PERCENT);
        final double FOURTH_TIER_TAX_MAX = ((fourth_tier_limit
                                            - third_tier_limit) * FOURTH_TIER_PERCENT);
        final double FIFTH_TIER_TAX_MAX = ((fifth_tier_limit
                                            - fourth_tier_limit) * FIFTH_TIER_PERCENT);
        
        // conditional statement calculates total tax depending 
        // on the tax bracket the user falls in                                   
        if (income <= first_tier_limit) {
            tax = income * FIRST_TIER_PERCENT;
        }
        else if (income <= second_tier_limit) {
            tax = FIRST_TIER_TAX_MAX;
            income -= first_tier_limit;
            tax += (income * SECOND_TIER_PERCENT);
        }
        else if (income <= third_tier_limit) {
            tax = FIRST_TIER_TAX_MAX + SECOND_TIER_TAX_MAX;
            income -= second_tier_limit;
            tax += (income * THIRD_TIER_PERCENT);
        }
        else if (income <= fourth_tier_limit) {
            tax = FIRST_TIER_TAX_MAX + SECOND_TIER_TAX_MAX + THIRD_TIER_TAX_MAX;
            income -= third_tier_limit;
            tax += (income * FOURTH_TIER_PERCENT);
        }
        else if (income <= fifth_tier_limit) {
            tax = FIRST_TIER_TAX_MAX + SECOND_TIER_TAX_MAX + THIRD_TIER_TAX_MAX + FOURTH_TIER_TAX_MAX;
            income -= fourth_tier_limit;
            tax += (income * FIFTH_TIER_PERCENT);
        }
        else {
            tax = FIRST_TIER_TAX_MAX + SECOND_TIER_TAX_MAX + THIRD_TIER_TAX_MAX + FOURTH_TIER_TAX_MAX + FIFTH_TIER_TAX_MAX;
            income -= fifth_tier_limit;
            tax += (income * SIXTH_TIER_PERCENT);
        }
        return tax;
    }
    
    public static void render_menu() {
        System.out.println(" ________________________________________");
        System.out.println("|           TAX STATUS                   |");
        System.out.println("|________________________________________|");
        System.out.println("|  0        Single                       |");
        System.out.println("|  1        Married Filing Jointly or    |");
        System.out.println("|           Qualifying Widow(er)         |");
        System.out.println("|  2        Married Filing Separately    |");
        System.out.println("|  3        Head of Household            |");
        System.out.println("|________________________________________|\n");
        System.out.print("Please choose your tax status (0 - 3): ");
    }
}