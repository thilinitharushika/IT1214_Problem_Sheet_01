class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }
}

// Bank.java
class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[5];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count] = account;
            count++;
        } else {
            System.out.println("Bank is full. Cannot add more accounts.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawn " + amount + " from account " + accountNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found: " + accountNumber);
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].display();
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount a1 = new BankAccount(1001, "Alice", 5000.0);
        BankAccount a2 = new BankAccount(1002, "Bob", 3000.0);

        bank.addAccount(a1);
        bank.addAccount(a2);

        bank.withdraw(1001, 6000.0); 
        bank.withdraw(1002, 1000.0); 

        bank.displayAllAccounts();
    }
}
