import java.util.Scanner;

class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) 
    {
        if (amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}

class ATM
{
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }

    public void displayOptions()
    {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double amount) 
    {
        if (account.withdraw(amount))
        {
            System.out.println("Remaining balance: ₹" + account.getBalance());
        }
    }

    public void deposit(double amount)
    {
        account.deposit(amount);
        System.out.println("New balance: ₹" + account.getBalance());
    }

    public void checkBalance()
    {
        System.out.println("Current balance: ₹" + account.getBalance());
    }
}

public class ATMInterface
{
    public static void main(String[] args) 
    {
        BankAccount bankAccount = new BankAccount(1111); // Initial balance
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) 
        {
            atm.displayOptions();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}


