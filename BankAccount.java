//Task4

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

 class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance $1000
        ATM atm = new ATM(userAccount);
        atm.processTransaction();
    }
}
 

 /* 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class ATMApplication {
    private BankAccount account;

    public ATMApplication(BankAccount account) {
        this.account = account;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("ATM Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel balanceLabel = new JLabel("Balance: $" + account.getBalance());
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        JTextField amountField = new JTextField(10);

        panel.add(balanceLabel);
        panel.add(new JLabel(""));
        panel.add(new JLabel("Enter Amount:"));
        panel.add(amountField);
        panel.add(new JLabel(""));
        panel.add(depositButton);
        panel.add(new JLabel(""));
        panel.add(withdrawButton);

        frame.getContentPane().add(panel);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    balanceLabel.setText("Balance: $" + account.getBalance());
                    amountField.setText("");
                    JOptionPane.showMessageDialog(frame, "Deposit successful.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (account.withdraw(amount)) {
                        balanceLabel.setText("Balance: $" + account.getBalance());
                        amountField.setText("");
                        JOptionPane.showMessageDialog(frame, "Withdrawal successful.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.");
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BankAccount userAccount = new BankAccount(1000.0);
                ATMApplication atm = new ATMApplication(userAccount);
                atm.createAndShowGUI();
            }
        });
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
*/
