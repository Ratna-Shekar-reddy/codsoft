import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// ATM Class
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + bankAccount.getBalance());
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("Successfully deposited " + amount + ". New balance is: " + bankAccount.getBalance());
    }

    public void withdraw(double amount) {
        if (bankAccount.getBalance() >= amount) {
            bankAccount.withdraw(amount);
            System.out.println("Successfully withdrawn " + amount + ". New balance is: " + bankAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }
}

// Main class for running the ATM
public class AtmMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Starting balance
        ATM atm = new ATM(account);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice:\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            int choice = scanner.nextInt();
            double amount;
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
