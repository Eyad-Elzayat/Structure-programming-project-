import java.util.Scanner;
//Hello From Eyad

public class Main {
    //methods
    public static void accountCreation(){
        System.out.println("Created");
    }
    public static void depositMoney(){

    }
    public static void withdrawMoney(){

    }
    public static void transferFunds(){

    }
    public static void interestCal(){

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
                            depositMoney();
                        }else if (operation == 2) {
                            withdrawMoney();
                        }else if (operation == 3) {
                            transferFunds();
                        }else {
                            System.out.println("This operation is not found, please try again");
                        }
                        break;
                    } else {
                        System.out.println("this account number doesn't exist");
                        System.out.println("1-Create new account");
                        System.out.println("2-Exit");
                        int CreateOrExit = sc.nextInt();
                        if (CreateOrExit == 1) {
                            accountCreation();
                            break;
                        } else if (CreateOrExit == 2) {
                            system = true;
                            break;
                        }
                    }
                }

            } else if (checking == 2) {
                accountCreation();
            } else if (checking == 3) {
                System.out.println("Thank you");
                system = true;
            }
        }
    }
}