public class testAccountBank {

    public static void main(String[] args) {
        // Create a savings account
        accountBank savingsAccount = new accountBank(accountBank.AccountType.SAVINGS, "SAV001");
        System.out.println("Created savings account with id " + savingsAccount.getAccountID());

        // Create a current account with an opening balance of 1000
        accountBank currentAccount = new accountBank(accountBank.AccountType.CURRENT, "CUR001", 1000);
        System.out.println("Created current account with id " + currentAccount.getAccountID());

        // Test getBalance method
        System.out.println("Savings account balance: " + savingsAccount.getBalance());
        System.out.println("Current account balance: " + currentAccount.getBalance());

        // Test withdraw method
        System.out.println("Withdrawing 500 from savings account...");
        boolean success = savingsAccount.withdraw(500);
        if (success) {
            System.out.println("Withdrawal successful. New balance: " + savingsAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed.");
        }

        System.out.println("Withdrawing 1500 from current account...");
        success = currentAccount.withdraw(1500);
        if (success) {
            System.out.println("Withdrawal successful. New balance: " + currentAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed.");
        }

        // Test deposit method
        System.out.println("Depositing 1000 into savings account...");
        savingsAccount.deposit(1000);
        System.out.println("New savings account balance: " + savingsAccount.getBalance());

        // Test getAccountType and getMinBalance methods
        System.out.println("Savings account type: " + savingsAccount.getAccountType() + ", minimum balance: " + savingsAccount.getMinBalance());
        System.out.println("Current account type: " + currentAccount.getAccountType() + ", minimum balance: " + currentAccount.getMinBalance());
         // test code for transfer method
        
         accountBank nicolecurrent = new accountBank(accountBank.AccountType.CURRENT, "CUR001", 1000);
         accountBank nicolesavings = new accountBank(accountBank.AccountType.SAVINGS, "SAV001");
         
             // test successful transfer from account1 to account2
         boolean transferSuccess = nicolecurrent.transfer(true, nicolesavings, 500);
         System.out.println("Transfer success: " + transferSuccess);
         System.out.println("Account 1 balance: " + nicolecurrent.getBalance());
         System.out.println("Account 2 balance: " + nicolesavings.getBalance());
         
             // test failed transfer due to insufficient balance in account1
         transferSuccess = nicolecurrent.transfer(true, nicolesavings, 10000);
         System.out.println("Transfer success: " + transferSuccess);
         System.out.println("Account 1 balance: " + nicolecurrent.getBalance());
         System.out.println("Account 2 balance: " + nicolesavings.getBalance());
         
             // test failed transfer due to exceeding withdrawal limit in account2
         transferSuccess = nicolecurrent.transfer(false, nicolesavings, 600);
         System.out.println("Transfer success: " + transferSuccess);
         System.out.println("Account 1 balance: " + nicolecurrent.getBalance());
         System.out.println("Account 2 balance: " + nicolesavings.getBalance());
         
    }
}
