public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();
        account1.accountDeposit("checkingAccount", 10.00);
        account2.accountDeposit("checkingAccount", 20.00);
        account3.accountDeposit("checkingAccount", 30.00);
        account1.accountDeposit("savingsAccount", 10.00);
        account2.accountDeposit("savingsAccount", 20.00);
        account3.accountDeposit("savingsAccount", 30.00);
        account1.myMoney();
        account2.myMoney();
        account3.myMoney();
    }
}
