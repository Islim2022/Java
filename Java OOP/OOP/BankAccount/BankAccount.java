import java.util.Random;

public class BankAccount {
    // Attributes
    private double checkingBalance = 0.0;
    private double savingsBalance = 0.0;
    private String accountNumber = "";
    private static int accountsCreated = 0; // Create a class member (static) that has the number of accounts created thus far.
    private static double totalMoney = 0.0; // Create a class member (static) that tracks the total amount of money stored in every account created.

    // Constructors
    public BankAccount() {
        String accountNumber = setAccountNumber();
        double checkingBalance = 0.0;
        double savingsBalance = 0.0;
        accountsCreated++;
        System.out.println("Total Number of Accounts Created is " + accountsCreated + ".");
    }

    // Getters
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Setters
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }
    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // Methods
    public String setAccountNumber() {
        Random randMachine = new Random();
        for(int i=0; i<10; i++);{
            int number = randMachine.nextInt(10) + 1;
            accountNumber += number;
        }
        return accountNumber;
    }

    public void accountDeposit(String type, double depositAmount) {
        if(type == "checkingAccount" || type == "checkingAccount") {
            setCheckingBalance(getCheckingBalance() + depositAmount);
            totalMoney += depositAmount;
        }
        if(type == "savingsAccount" || type == "savingsAccount") {
            setSavingsBalance(getSavingsBalance() + depositAmount);
            totalMoney += depositAmount;
        }
    }
    public void accountWithdrawl(String type, double withdrawlAmount) {
        if(type == "checkingAccount" || type == "checkingAccount") {
            if(getCheckingBalance() < withdrawlAmount) {
                System.out.println("Insufficient Funds!");
            }
            else {
                setCheckingBalance(getCheckingBalance() - withdrawlAmount);
                totalMoney -= withdrawlAmount;
            }
        }

        if(type == "savingsAccount" || type == "savingsAccount") {
            if(getSavingsBalance() < withdrawlAmount) {
                System.out.println("Insufficient Funds!");
            }
            else {
                setSavingsBalance(getSavingsBalance() - withdrawlAmount);
                totalMoney -= withdrawlAmount;
            }
        }
    }
            public double myMoney() {
            double totalBalance = checkingBalance + savingsBalance;
            System.out.println(totalBalance);
            return totalBalance;
        }
}