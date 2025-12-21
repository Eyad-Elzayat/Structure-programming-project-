import java.util.Scanner;
//Hello From Eyad

public class Main {
    //methods
    public static void accountCreation(int[] account , int[] accountType,double[] amount ,String[] name) {
        int index = 0;
        for (int i = 0; i < account.length; i++) {
            if (account[i] == 0) {
                index = i;
                break;
            }
        }
        int accountnumber = 1000+index;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter account name: ");
        name[index] = input.nextLine();
        System.out.print("Choose your account type\n1-Checking\n2-Saving\nEnter account type: ");
        accountType[index] = input.nextInt();
        if (accountType[index] == 2) {
            System.out.print("Enter amount: ");
            amount[index] = input.nextDouble();
            if (amount[index] >= 100) {
                account[index] = ++accountnumber;
                System.out.println("Saving account created successfully");
                System.out.println("Accountnumber:" + account[index]);
                System.out.println("Accounttype:" + "saving");
                System.out.println("Balance:" + amount[index]);
            } else {
                System.out.println("Cannot create saving account\nMinimum amount is 100");
            }
        } else if (accountType[index] == 1) {
            System.out.println("Enter amount:");
            account[index] = ++accountnumber;
            amount[index] = input.nextDouble();
            System.out.println("Checking account created successfully");
            System.out.println("Account number=" + account[index]);
            System.out.println("Account type:" + "checking");
            System.out.println("Balance:" + amount[index]);
        } else {
            System.out.println("invalid account type");
        }
    }
    public static void depositMoney(int accountNum,double[] balance){
        Scanner sc = new Scanner(System.in);
        int index = accountNum-1001;
        System.out.println("Enter amount: ");
        double addedAmount = sc.nextDouble();
        balance[index] += addedAmount;
    }
    public static void withdrawMoney(int accountNum,int type ,int[] withdrawCnt,double[] balance){
        Scanner sc = new Scanner(System.in);
        int index = accountNum-1001;

        if (type == 1) {
            System.out.print("Enter the amount: ");
            double amount = sc.nextDouble();
            if (balance[index] >= amount) {
                balance[index] -= amount;
                withdrawCnt[index]++;
            }else {
                System.out.println("this amount is not available");
            }
        } else if (type == 2) {
            if (withdrawCnt[index] < 3) {
                System.out.print("Enter the amount: ");
                double amount = sc.nextDouble();
                if ((balance[index] - amount) >= 100) {
                    balance[index] -= amount;
                    withdrawCnt[index]++;
                }else{
                    System.out.println("Savings accounts cannot drop below $100");
                }
            }else {
                System.out.println("\"Error: Limit Reached\"5555");
            }
        }
    }
    public static void transferFunds(int accountNum,int type ,double[] balance,int[] accounts){
        Scanner sc = new Scanner(System.in);
        int sourceIndex = accountNum-1001;
        System.out.println("Enter Destination Account: ");
        int destination = sc.nextInt();
        for (int i = 0; i < accounts.length; i++) {
            if (destination == accounts[i]) {
                int destIndex = destination-1001;
                if (type == 1) {
                    System.out.print("Enter the amount: ");
                    double amount = sc.nextDouble();
                    if (balance[sourceIndex] >= amount) {
                        balance[sourceIndex] -= amount;
                        balance[destIndex] += amount;
                        System.out.println(balance[sourceIndex]);
                        System.out.println(balance[destIndex]);
                    }else {
                        System.out.println("This amount doesn't exist");
                    }
                } else if (type == 2) {
                    System.out.print("Enter the amount: ");
                    double amount = sc.nextDouble();
                    if ((balance[sourceIndex] - amount) >= 100) {
                        balance[sourceIndex] -= amount;
                        balance[destIndex] += amount;
                        System.out.println(balance[sourceIndex]);
                        System.out.println(balance[destIndex]);
                    }else{
                        System.out.println("Savings accounts cannot drop below $100");
                    }
                }
            }
        }
    }
    public static void interestCal(int[] accNums ,int[] accTypes,double[] balance){
        for (int i = 0; i < accNums.length; i++) {
            if (accTypes[i] == 2) {
                balance[i] *= 0.02;
                System.out.println("Interest applied to Account #" + accNums[i]);
            }
        }
    }

    public static void main(String[] args) {
        //setting up scanner
        Scanner sc = new Scanner(System.in);

        //setting up main data structure
        int maxUsers = 50;
        int[] accountNumbers = new int[maxUsers];
        String[] accountNames = new String[maxUsers];
        int[] accountTypes = new int[maxUsers];
        double[] balances = new double[maxUsers];
        int[] withdrawalsCount = new int[maxUsers];



        //Checking if the user have account
        boolean system = false;
        while (system == false){
            System.out.println("1-Enter to my account");
            System.out.println("2-Create new account");
            System.out.println("3-Exit");
            int checking = sc.nextInt();
            if (checking == 1) {
                System.out.print("Enter your account number: ");
                int accountExist = sc.nextInt();
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (accountNumbers[i] == accountExist) {
                        System.out.println("Welcome to AIU Bank");
                        System.out.println("Please select the operation you want: ");
                        System.out.println("1. Deposit Money");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. Transfer Funds");
                        int operation = sc.nextInt();
                        if (operation == 1) {
                            depositMoney(accountNumbers[i],balances);
                            System.out.println("The new balance: " + balances[i]);
                        }else if (operation == 2) {
                            withdrawMoney(accountNumbers[i],accountTypes[i],withdrawalsCount,balances);
                        }else if (operation == 3) {
                            transferFunds(accountNumbers[i],accountTypes[i],balances,accountNumbers);
                        }else {
                            System.out.println("This operation is not found, please try again");
                        }
                    }
                }

            } else if (checking == 2) {
                accountCreation(accountNumbers,accountTypes,balances,accountNames);
            } else if (checking == 3) {
                System.out.println("Thank you");
                system = true;
            }
            interestCal(accountNumbers,accountTypes,balances);
        }
    }
}