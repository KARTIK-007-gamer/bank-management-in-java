import java.util.*;

class BankDetails {
    // Declaring the scanner class
    Scanner sc = new Scanner(System.in);

    // Declaring the private variables
    private String acc_no;
    private String acc_type;
    private String name;
    private long balance = 0;
    private long phn_no;

    // Method to open new account
    public void openAccount() {
        System.out.println("Enter Your Account Number:");
        acc_no = sc.next();
        System.out.println("Enter Your Account Type:");
        acc_type = sc.next();
        System.out.println("Enter Your Name:");
        name = sc.next();
        System.out.println("Enter Your Phone Number:");
        phn_no = sc.nextLong();
    }

    // Creating the method that shows the details
    public void showDetails() {
        System.out.println("Account Number: " + acc_no);
        System.out.println("Account Type: " + acc_type);
        System.out.println("Name: " + name);
        System.out.println("Phone Number:"+phn_no);
        System.out.println("Balance: " + balance);

    }

    // Creating method to deposit the money
    public void moneyDeposit() {
        long amt;
        System.out.println("Enter Your Amount To Deposit:");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    // Creating method that withdraws the money
    public void moneyWithdraw() {
        long amt1;
        System.out.println("Enter Your Amount To Withdraw:");
        amt1 = sc.nextLong();
        if (balance < amt1) {
            System.out.println("Sorry, Your Balance Is Less Than Your Amount");
        } else {
            balance = balance - amt1;
            System.out.println("Your Amount Is Successfully Withdrawn: " + amt1);
            System.out.println("Balance After Withdrawal: " + balance);
        }
    }

    // Creating method to search an account number
    public boolean accSearch(String acc_no) {
        if (this.acc_no.equals(acc_no)) {
            showDetails();
            return true;
        } else {
            return false;
        }
    }
}

public class BankingApp1{
    public static void main(String[] args) {
        // Creating the scanner class 
        Scanner sc = new Scanner(System.in);

        // Creating initial account 
        System.out.println("Enter How Many Number of Customers Do You Want To Input:");
        int n = sc.nextInt();

        BankDetails c[] = new BankDetails[n];
        for (int i = 0; i < c.length; i++) {
            c[i] = new BankDetails();
            c[i].openAccount();
        }

        int ch;
        do {
            System.out.println("**** Banking System Application ****");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Search Account Using Account Number");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Withdraw Amount");
            System.out.println("5. Exit");
            System.out.println("Please Enter Your Choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    for (int i = 0; i < c.length; i++) {
                        c[i].showDetails();
                    }
                    break;

                case 2:
                    System.out.println("Enter Your Account Number To Search:");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < c.length; i++) {
                        found = c[i].accSearch(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed!!! Account Not Registered");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No.: ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < c.length; i++) 
                        {  
                            found = c[i].accSearch(ac_no);  
                            if (found) {  
                                c[i].moneyDeposit();
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        } 
                        break;
        
                        case 4:
                        System.out.println("Enter Your Amount To Withdraw:");
                        ac_no = sc.next();
                        found = false;
                        for(int i=0;i<c.length;i++){
                            found = c[i].accSearch(ac_no);
                            if(found){
                                c[i].moneyWithdraw();
                                break;
                            }
        
                        }
                        if(!found){
                            System.out.println("Search To Failed!!! Account Doesn't Exist...!!!!");
                        }
                        break;
        
                        case 5:
                            System.out.println("See You Soon.........");
                            break;
                        
                    }
                }
                while( ch != 5);
            }
        }