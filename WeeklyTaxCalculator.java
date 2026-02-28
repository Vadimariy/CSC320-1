import java.util.Scanner;

public class WeeklyTaxCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double weeklyIncome;
        double taxRate;
        double taxWithholding;

        // Prompt user
        System.out.print("Enter weekly income: $");
        weeklyIncome = input.nextDouble();

        // Determine tax rate
        if (weeklyIncome < 500) {
            taxRate = 0.10;
        } 
        else if (weeklyIncome < 1500) {
            taxRate = 0.15;
        } 
        else if (weeklyIncome < 2500) {
            taxRate = 0.20;
        } 
        else {
            taxRate = 0.30;
        }

        // Calculate tax
        taxWithholding = weeklyIncome * taxRate;

        // Display results
        System.out.printf("Weekly Income: $%.2f%n", weeklyIncome);
        System.out.printf("Tax Withholding: $%.2f%n", taxWithholding);
        System.out.printf("Take-Home Pay: $%.2f%n", (weeklyIncome - taxWithholding));

        input.close();
    }
}