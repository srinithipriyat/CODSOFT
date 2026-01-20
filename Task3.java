import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initial) {
        balance = initial;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println(amt + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amt > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amt;
            System.out.println(amt + " withdrawn successfully.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        int ch;
        do {
            System.out.println("\n------ ATM MENU ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (ch != 4);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        account.deposit(amt);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        account.withdraw(amt);
    }
}

public class Task3 {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(5000);
        ATM atm = new ATM(userAccount);

        atm.showMenu();
    }
}

