package mortgage.oop;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;


    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
    }

    public void printMortgage() {
        double result = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(result);

        System.out.println("mortgage");
        System.out.println("-----------------");
        System.out.println("monthly payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        System.out.println("------------------");
        System.out.println("Number of remaining installments: ");

        for (double balance: calculator.getReminingBalance()){
            System.out.println( NumberFormat.getCurrencyInstance().format(balance));
        }
    }

}
