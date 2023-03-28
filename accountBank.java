public class accountBank {
    public enum AccountType {
        CURRENT,
        SAVINGS
    }

    private AccountType acctType;
    private String acctID;
    private double balance;
    private boolean inTheRed;
    private double minBalance;
    private double interestRate;
    private double maintenanceFee;
    private int numWithdrawals;
    private int withdrawalLimit;
    //defined constants
    public static final int MONTHS_PER_YEAR = 12;
    public static final double SAVINGS_ACCT_MIN_BALANCE = 30;
    public static final double CURRENT_ACCT_MIN_BALANCE = 6.00;
    public static final double SAVINGS_ACCT_INTEREST_RATE = 0.06;
    public static final double CURRENT_ACCT_MAINTENANCE_FEE = 2.0;
    public static final int SAVINGS_WITHDRAWAL_LIMIT = 2;

    // A constructor that takes account type and id
    public accountBank(AccountType type, String id) {
        this.acctType = type;
        this.acctID = id;
        balance=0;
        numWithdrawals=0;

        if (type == AccountType.CURRENT) {
            this.minBalance = CURRENT_ACCT_MIN_BALANCE;
            this.interestRate = 0;
            this.maintenanceFee = CURRENT_ACCT_MAINTENANCE_FEE;
            withdrawalLimit=-1;
        } else {
            this.minBalance = SAVINGS_ACCT_MIN_BALANCE;
            this.interestRate = SAVINGS_ACCT_INTEREST_RATE;
            this.maintenanceFee = 0;
            withdrawalLimit= SAVINGS_WITHDRAWAL_LIMIT;
        }

        //this.balance = 0;
        inTheRed = (this.balance < this.minBalance);
        //this.withdrawalLimit = (type == AccountType.CURRENT) ? -1 : SAVINGS_WITHDRAWAL_LIMIT;
    }

    // TO DO: Define a constructor that takes the account type, id,
  // and opening balance
    public accountBank(AccountType type, String id, double openingBalance) {
        this.acctType=type;
        this.acctID=id;
        this.balance = openingBalance;
        this.inTheRed = (this.balance < this.minBalance);
    }

    // TO DO: Define the getBalance() method
    public double getBalance() {
        return balance;
    }
    
  // TO DO: Define the getAccountType() method
    public AccountType getAccountType() {
        return acctType;
    }
    // TO DO: Define the getAccountID() method
    public String getAccountID() {
        return acctID;
    }
    // TO DO: Define the getMinBalance() method
    public double getMinBalance() {
        return minBalance;
    }

   // TO DO: Define the withdraw() method
    public boolean withdraw(double amount) {
        if (this.withdrawalLimit != -1 && this.numWithdrawals >= this.withdrawalLimit) {
            System.out.println("Sorry, could not perform withdrawal: Maximum number of withdrawals reached.");
            return false;
        } else if (amount > this.balance - this.minBalance) {
            System.out.println("Sorry, could not perform withdrawal: Insufficient balance.");
            return false;
        } else {
            this.balance -= amount;
            this.numWithdrawals++;
            this.inTheRed = (this.balance < this.minBalance);
            return true;
        }
    }
    // TO DO: Define the deposit() method
    public void deposit(double amount) {
        this.balance += amount;
        this.inTheRed = (this.balance < this.minBalance);
    }
    
     // TO DO: Define the performMonthlyMaintenance() method 
     public void performMonthlyMaintenance() {
        // Deduct monthly maintenance fee
        if (type == AccountType.CURRENT){
            double fee = CURRENT_ACCT_MAINTENANCE_FEE;
            this.withdraw(fee);
        }
        else {
            double fee = 0;
            this.withdraw(fee);

            

        }
    // DEFINE TRANSFER METHOD
    public boolean transfer(boolean transferTo, accountBank otherAccount, double amount) {
        if (transferTo) {
            // Withdraw the amount from this bank account
            boolean withdrawSuccessful = withdraw(amount);
            if (withdrawSuccessful) {
                // Deposit the amount into the other bank account
                otherAccount.deposit(amount);
                return true;
            } else {
                // Withdrawal was not successful, no transfer is performed
                return false;
            }
        } else {
            // Withdraw the amount from the other bank account
            boolean withdrawSuccessful = otherAccount.withdraw(amount);
            if (withdrawSuccessful) {
                // Deposit the amount into this bank account
                deposit(amount);
                return true;
            } else {
                // Withdrawal was not successful, no transfer is performed
                return false;
            }
        }
    
    
    }  
}
