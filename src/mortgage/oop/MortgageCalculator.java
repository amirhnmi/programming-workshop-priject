package mortgage.oop;

public class MortgageCalculator {
    private int loan;
    private float interestRate;
    private byte periodYears;

    public final static byte MONTHS_IN_YEAR = 12;
    public final static   byte PERCENT = 100;

    public MortgageCalculator(int loan,float interestRate,byte periodYears){
        this.loan = loan;
        this.interestRate = interestRate;
        this.periodYears = periodYears;
    }

    public double calculateMortgage() {
//       this method calculate installment
        float monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        double result = loan * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return result;
    }

    private int getNumberOfPayments() {
        return periodYears * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return interestRate / PERCENT / MONTHS_IN_YEAR;
    }

    public double calculateBalance(short numberOFPaymentMade) {
//       this method calculate balance of the total installment after paying each installment
        float monthlyInterestRate = getMonthlyInterestRate();
        int numberOfPayments = getNumberOfPayments();

        double balance = loan *
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOFPaymentMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return balance;
    }

    public double[] getReminingBalance(){
        double[] balance = new double[getNumberOfPayments()];
        for (short month = 1; month < balance.length; month ++){
            balance[month - 1] = calculateBalance(month);
        }
        return balance;
    }

}
