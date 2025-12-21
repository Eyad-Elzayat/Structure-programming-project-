import java.util.Scanner;
//Hello From Eyad
//hello from mariam

public class Main {
    //methods
    public static void accountCreation() {
        int[] account = new int[50];//array of size 50
        int index=0;//start point of array
        int accountnumber = 1000;//last account number
        while (true) {//loop so the program keeps running continuously
            Scanner input = new Scanner(System.in);//open scanner
            System.out.println("Choose your account type\n1-Checking\n2-Saving\nEnter account type:");//ask the user to enter account type
            int accounttype = input.nextInt();//read an integer number from the user
            if (accounttype == 2) {//if the user chose saving account
                System.out.println("Enter amount:");//ask the user to enter amount
                double amount = input.nextDouble();//read a decimal number from user
                if (amount >= 100) {//if the amount the user entered is more than 100 account will be created successfully
                    accountnumber++;//generate sequential number
                    account[index] = accounttype;//store the account number in the first index
                    index++;//move to the next index
                    System.out.println("Saving account created successfully");//display message when a saving account is successfully created
                    System.out.println("Accountnumber:" + accountnumber);//display account number to the user
                    System.out.println("Accounttype:" + "saving");//display account type to the user
                    System.out.println("Balance:" + amount);//display account balance to the user
                } else {// if the amount less than 100 account will not be created
                    System.out.println("Cannot create saving account\nMinimum amount is 100");//display message if minimum deposit is less than 100
                }
            } else if (accounttype == 1) {// if the user chose checking account
                accountnumber++;//generate sequential number
                account[index] = accounttype;//store the account number
                index++;//move to the next index
                System.out.println("Checking account created successfully");//display message when checking account is created
                System.out.println("Account number=" + accountnumber);//display account number to the user
                System.out.println("Accounttype:" + "checking");//display account type to the user
            } else {//if the user enters any number other than 1 and 2 it will be rejected
                System.out.println("invalid account type");//display message if any number other than 1 and 2 is chosen
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