import java.util.*;
import java.io.*;

class bankDetails{
    //declaring the scanner class
    Scanner sc = new Scanner(System.in);

    //declaring the private  variables
    private String acc_no;
    private String acc_type;
    private String name;
    private long balance = 0;
    

    //method to open new account
    public  void openAccount(){
        System.out.println("Enter Your Account Number:");
        acc_no = sc.next();
        System.out.println("Enter Your Accout Type:");
        acc_type = sc.next();
        System.out.println("Enter Your Name:");
        name = sc.next();
    }

    //creating the method that showing the details
    public void showDetails(){
        System.out.println("Account Number :"+acc_no);
        System.out.println("Account Type :"+acc_type);
        System.out.println("Name :"+name);
        System.out.println("Balance :"+balance);
    }

    // creating method to deposit the money
    public void money_deposit(){
        long amt;
        System.out.println("Enter Your Amount To Deposit:");
        amt = sc.nextLong();
        balance=balance+amt;
    }

    //creating method that withdraw the money
    public void money_withdraw(){
        long amt1;
        System.out.println("Enter Your Amount To Withdraw:");
        amt1=sc.nextLong();
        if(balance<amt1){
            System.out.println("Sorry Your Balance Is Greater Than Your Amount");
        }else{
            balance=balance-amt1;
            System.out.println("Your Amount Is Successfully Withdraw "+amt1);
            System.out.println("Balance After Withdraw "+balance);
        }
    }

    //creating method to search an account number
    public boolean accSearch(String acc_no){
        if(acc_no.equals(acc_no)){
            showDetails();
            return(true);
        }
        else{
            return(false);
        }
    }
}
public class bankingApp{
    public static void main(String [] args){
        // creating the scanner class 
        Scanner sc= new Scanner(System.in);

        // creating initial account 
        System.out.println("Enter How Many Number of Customers Do You Want To Input:");
        int n = sc.nextInt();

        bankDetails c[]= new bankDetails[n];
        for(int i = 0; i<c.length;i++)
        {
            c[i]= new bankDetails();
            c[i].openAccount();
        }
        int ch;
        do{
            System.out.println("**** Banking System Application ****");
            System.out.println("1.Display All Account");
            System.out.println("2.Search Account Using Account Number");
            System.out.println("3.Deposit Amount");
            System.out.println("4.Withdraw Amount");
            System.out.println("5.Exit");
            System.out.println("Please Enter Your Choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    for(int i = 0;i<c.length;i++){
                        c[i].showDetails();
                    }
                    break;
                
                case 2:
                    System.out.println("Enter Your Account Number To Search:");
                    String ac_no = sc.next();
                    boolean found = false;
                    for(int i=0; i < c.length;i++){
                        found = c[i].accSearch(ac_no);
                        if(found){
                            break;
                        }
                    if(!found){
                        System.out.println("Search Failed!!! Account Not Register");
                    }
                    }
                    break;

                case 3:
                System.out.print("Enter Account no. : ");  
                ac_no = sc.next();  
                found = false;  
                for (int i = 0; i < c.length; i++) {  
                    found = c[i].accSearch(ac_no);  
                    if (found) {  
                        c[i].money_deposit();  
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
                        c[i].money_withdraw();
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