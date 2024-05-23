package mortgage.oop;

public class Main {

    public static void main(String[] s){
        int loan = (int) Console.readNumber("loan amount: ",1000,1_000_000);
        float interestRate = (float) Console.readNumber("annual interest rate: ",1,30);
        byte  periodYears = (byte) Console.readNumber("period (years): ",1,30);

        var calculator = new MortgageCalculator(loan,interestRate,periodYears);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}




