import java.util.Scanner;
//Hello From Eyad
//hello from mariam

public class Main {
    //methods
    public static void accountCreation(){

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

        //main functions
        System.out.println("Please select the operation you want: ");
        System.out.println("1. Account Creation");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Interest Calculator");

        int operation  = sc.nextInt();

        if (operation == 1) {
            accountCreation();
        }else if (operation == 2) {
            depositMoney();
        }else if (operation == 3) {
            withdrawMoney();
        }else if (operation == 4) {
            transferFunds();
        }else if (operation == 5) {
            interestCal();
        }else {
            System.out.println("This operation is not found, please try again");
        }
    }
}