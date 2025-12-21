import java.util.Scanner;
//Hello From Eyad
//hello from mariam

public class Main {
    //methods
    public static void accountCreation() {
        int[] account = new int[50];
        int index=0;
        int accountnumber = 1000;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose your account type\n1-Checking\n2-Saving\nEnter account type:");
            int accounttype = input.nextInt();
            if (accounttype == 2) {
                System.out.println("Enter amount:");
                double amount = input.nextDouble();
                if (amount >= 100) {
                    accountnumber++;
                    account[index] = accounttype;
                    index++;
                    System.out.println("Saving account created successfully");
                    System.out.println("Accountnumber:" + accountnumber);
                    System.out.println("Accounttype:" + "saving");
                    System.out.println("Balance:" + amount);
                } else {
                    System.out.println("Cannot create saving account\nMinimum amount is 100");
                }
            } else if (accounttype == 1) {
                accountnumber++;
                account[index] = accounttype;
                index++;
                System.out.println("Checking account created successfully");
                System.out.println("Account number=" + accountnumber);
                System.out.println("Accounttype:" + "checking");
            } else {
                System.out.println("invalid account type");
            }
        }
    }
}
    public static void depositMoney() {

    }

    public static void withdrawMoney() {

    }

    public static void transferFunds() {

    }

    public static void interestCal() {

    }

    public static void main(String[] args) {
        //setting up scanner
        Scanner sc = new Scanner(System.in);

        //setting up main data structure
        int maxUsers = 50;
        int[] accountNumbers = new int[maxUsers];
        String[] accountNames = new String[maxUsers];
        double[] balances = new double[maxUsers];
        int[] accountTypes = new int[maxUsers];
        int[] withdrawalsCount = new int[maxUsers];

        //main functions
        System.out.println("Please select the operation you want: ");
        System.out.println("1. Account Creation");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Interest Calculator");

        int operation = sc.nextInt();

        if (operation == 1) {
            accountCreation();
        } else if (operation == 2) {
            depositMoney();
        } else if (operation == 3) {
            withdrawMoney();
        } else if (operation == 4) {
            transferFunds();
        } else if (operation == 5) {
            interestCal();
        } else {
            System.out.println("This operation is not found, please try again");
        }
    }