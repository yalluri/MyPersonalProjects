import java.text.NumberFormat;
import java.util.Scanner;

class MortguageCalculator {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        // Principal input validation
        int principal;
        while (true) {
            System.out.println("Principal:");
            principal = scanner.nextInt();
            if (principal >= 100 && principal <= 10000000)
                break;
            System.out.println("Enter a value between 1 and 10000000");
        }

        // Annual Interest Rate input validation
        float annualInterestRate;
        while (true) {
            System.out.println("Annual Interest Rate:");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 1 && annualInterestRate < 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        // Period input validation
        byte period;
        while (true) {
            System.out.println("Enter Period (in Years):");
            period = scanner.nextByte();
            int numberOfPayments = period * MONTHS_IN_YEAR;
            if (period >= 1 && period <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, period * MONTHS_IN_YEAR)) /
                (Math.pow(1 + monthlyInterestRate, period * MONTHS_IN_YEAR) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}