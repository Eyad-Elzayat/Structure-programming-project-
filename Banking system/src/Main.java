import javax.swing.JOptionPane;

public class Main {


    //Eyad Mahmoud Ebrahim Elzayat 25102344
    //maryam ibrahem abd alsabor  25102374
    //Haitham hesham 25102329
    //Mariyam Ahmed Mohammed Kholafa  25102365
    //Omar Tarekk 25102370


    //methods
    //Creating account
    public static void accountCreation(int[] account , int[] accountType,double[] amount ,String[] name) {
        //the logic of the creation is to found how many accounts i created
        //as we know the arrays are declared with 50 places and the empty spaces for the numbered arrays = 0
        //our account number array element starts with 1001 so there is no account starts with 0 so if the loop found 0 this is the index we will create the user at
        int index = 0;
        for (int i = 0; i < account.length; i++) {
            if (account[i] == 0) {
                index = i;
                break;
            }
        }
        //here we get data from the user and give him an account number
        int accountnumber = 1000+index;
        name[index]= JOptionPane.showInputDialog("Enter account name: ");

        //choosing the type of the account
        //1 for checking
        //2 for saving
        String accType = JOptionPane.showInputDialog("Choose your account type\n1-Checking\n2-Saving\nEnter account type: ");
        accountType[index] = Integer.parseInt(accType);

        if (accountType[index] == 2) {
            //checking the savings rules
            String amount1 = JOptionPane.showInputDialog("Enter the amount: ");
            amount[index] = Double.parseDouble(amount1);
            if (amount[index] >= 100) {
                account[index] = ++accountnumber;
                JOptionPane.showMessageDialog(null, "Saving account created successfully \nAccount Name: "+ name[index] +"\nAccountnumber:" + account[index] +" \nAccounttype: saving\n Balance: " + amount[index]);
            } else {
                JOptionPane.showMessageDialog(null,"Cannot create saving account\nMinimum amount is 100");

            }
        } else if (accountType[index] == 1) {
            //creating a checking account
            String amount1 = JOptionPane.showInputDialog("Enter the amount: ");
            amount[index] = Double.parseDouble(amount1);
            account[index] = ++accountnumber;
            JOptionPane.showMessageDialog(null, "Saving account created successfully \nAccount Name: "+ name[index] +"\nAccountnumber:" + account[index] +" \nAccounttype: checking\n Balance: " + amount[index]);
        } else {
            JOptionPane.showMessageDialog(null,"invalid account type");
        }
    }

    //deposit Money Method
    public static void depositMoney(int accountNum,double[] balance){
        // here you already have the user index (you login before choosing the method)
        int index = accountNum-1001; //this line just getting the user place in the database
        // the logic of this method that you get the user index in the database and you add the amount
        String addedAmount1 = JOptionPane.showInputDialog("Enter the amount: ");
        double addedAmount = Double.parseDouble(addedAmount1);
        balance[index] += addedAmount;
    }
    //Withdraw Money Method
    public static void withdrawMoney(int accountNum,int type ,int[] withdrawCnt,double[] balance){
        // here you already have the user index (you login before choosing the method)
        int index = accountNum-1001; //this line just getting the user place in the database
        //checking the type for the rules
        if (type == 1) {
            //if checking account the withdraw method will work if the amount are available
            String amount1 = JOptionPane.showInputDialog("Enter the amount: ");
            double amount = Double.parseDouble(amount1);
            if (balance[index] >= amount) {
                balance[index] -= amount;
                withdrawCnt[index]++;
            }else {
                JOptionPane.showMessageDialog(null,"this amount is not available");
            }
        } else if (type == 2) {
            //if saving account the withdraw method will work if the user didn't reach the limit and if the amount will not drop the acccount under 100$
            if (withdrawCnt[index] < 3) {
                String amount1 = JOptionPane.showInputDialog("Enter the amount: ");
                double amount = Double.parseDouble(amount1);
                if ((balance[index] - amount) >= 100) {
                    balance[index] -= amount;
                    withdrawCnt[index]++;
                }else{
                    JOptionPane.showMessageDialog(null,"Savings accounts cannot drop below $100");
                }
            }else {
                JOptionPane.showMessageDialog(null,"\"Error: Limit Reached\"5555");
            }
        }
    }

    //Transfer Money Method
    public static void transferFunds(int accountNum,int type ,double[] balance,int[] accounts){
        // here you already have the user index (you login before choosing the method)
        int sourceIndex = accountNum-1001; //this line just getting the user place in the database
        //getting the destination
        String dest = JOptionPane.showInputDialog("Enter Destination Account: ");
        int destination = Integer.parseInt(dest);

        //searching for the destination
        boolean found = false;
        for (int i = 0; i < accounts.length; i++) {
            if (destination == accounts[i]) {
                found = true;
                //getting the destination account place in the database
                int destIndex = destination-1001;
                //checking for the source account type to apply the rules
                if (type == 1) {
                    String amount1 = JOptionPane.showInputDialog("Enter the amount: ");
                    double amount = Double.parseDouble(amount1);
                    if (balance[sourceIndex] >= amount) {
                        balance[sourceIndex] -= amount;
                        balance[destIndex] += amount;
                    }else {
                        JOptionPane.showMessageDialog(null,"This amount doesn't exist");
                    }
                } else if (type == 2) {
                    String amount1 = JOptionPane.showInputDialog("Enter the amount: ");
                    double amount = Double.parseDouble(amount1);
                    if ((balance[sourceIndex] - amount) >= 100) {
                        balance[sourceIndex] -= amount;
                        balance[destIndex] += amount;
                    }else{
                        JOptionPane.showMessageDialog(null,"Savings accounts cannot drop below $100");
                    }
                }
            }
        }

        //if the loop reached the end and the user not found this massage will apper and it will go back to the home page
        if (!found) {JOptionPane.showMessageDialog(null,"user not found");}
    }

    //Interest Method
    public static void interestCal(int[] accNums ,int[] accTypes,double[] balance){
        for (int i = 0; i < accNums.length; i++) {
            if (accTypes[i] == 2) {
                balance[i] *= 1.02;
                JOptionPane.showMessageDialog(null,"Interest applied to Account #" + accNums[i]);
            }
        }
    }
    //admin Method
    public static void adminMethod(int users,String[] names,int[] nums,int[] types,int[] withdraw,double[] balance){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index = i;
                break;
            }
        }
        int numOfUsers =  index;
        if (numOfUsers == 0) {
            JOptionPane.showMessageDialog(null,"No users yet");
        }else {
            for (int i = 0; i < numOfUsers; i++) {
                JOptionPane.showMessageDialog(null,
                        "Number of users = " + numOfUsers+ "\n"
                                + "Account Number :" + nums[i]+ "\n"
                                + "Name :" + names[i]+ "\n"
                                + "Type :" + types[i]+ "\n"
                                + "Withdraw count :" + withdraw[i] + "\n"
                                + "Balance :" + balance[i] + "\n"
                );
            }
        }
    }

/// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Main method
    public static void main(String[] args) {
        //setting up scanner
        //setting up main data structure
        int maxUsers = 50;
        int[] accountNumbers = new int[maxUsers];
        String[] accountNames = new String[maxUsers];
        int[] accountTypes = new int[maxUsers];
        double[] balances = new double[maxUsers];
        int[] withdrawalsCount = new int[maxUsers];

        //Main program loop
        boolean system = false;
        while (system == false){
            // Login logic
            //1 for login and do the main methods
            //2 for creating new account
            //3 for ending the process and closing the program
            String checking1 = JOptionPane.showInputDialog("1-Enter to my account\n2-Create new account\n3-Admin account\n4-Exit");
            int checking = Integer.parseInt(checking1);
            if (checking == 1) {
                String accountExist1 = JOptionPane.showInputDialog("Enter your account number: ");
                int accountExist = Integer.parseInt(accountExist1);
                //Checking if the user have account or not
                boolean found = false;
                for (int i = 0; i < accountNumbers.length; i++) {
                    if (accountNumbers[i] == accountExist) {
                        found = true;
                        String operation1 = JOptionPane.showInputDialog("Welcome " + accountNames[i] + " to AIU Bank\nPlease select the operation you want: \n1. Deposit Money\n2. Withdraw Money\n3. Transfer Funds");
                        int operation = Integer.parseInt(operation1);
                        if (operation == 1) {
                            depositMoney(accountNumbers[i],balances);
                            JOptionPane.showMessageDialog(null,"The new balance: " + balances[i]);
                        }else if (operation == 2) {
                            withdrawMoney(accountNumbers[i],accountTypes[i],withdrawalsCount,balances);
                        }else if (operation == 3) {
                            transferFunds(accountNumbers[i],accountTypes[i],balances,accountNumbers);
                        }else {
                            JOptionPane.showMessageDialog(null,"This operation is not found, please try again");
                        }
                    }
                }
                //if the loop reached the end and the user not found this massage will apper and it will go back to the home page
                if (!found) {JOptionPane.showMessageDialog(null,"user not found");}

                //this method is here because i don't know when to insert the new annualy money and it not mentioned with a time for this case
                interestCal(accountNumbers,accountTypes,balances);
            } else if (checking == 2) {
                accountCreation(accountNumbers,accountTypes,balances,accountNames);
                //this method is here because i don't know when to insert the new annualy money and it not mentioned with a time for this case
                interestCal(accountNumbers,accountTypes,balances);
            } else if (checking == 3) {
                adminMethod(maxUsers,accountNames,accountNumbers,accountTypes,withdrawalsCount,balances);
            } else if (checking == 4) {
                JOptionPane.showMessageDialog(null,"Thank you");
                system = true;
            }
        }
    }
}