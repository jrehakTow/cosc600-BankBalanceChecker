package cosc600prj2;
import java.io.File;
import java.util.Scanner;

public class IOaccounts {
    
    //the variables
    public String name; 
    int acnt_num;
    String phone;
    String ssn;
    double bal;
    double close_bal;
    char type; 
          
    private Scanner bank_file;
    
    public void openFile(){
        try{
            bank_file = new Scanner(new File("src/accounts.txt"));
        }
        catch(Exception e){
            System.out.println("Can't find bank accounts file");
        }       
    }  
    
    public int accountCounter(){
        int count = 0;
        while(bank_file.hasNext()){
           count++;
           bank_file.nextLine();
        }
        return count;
    }
    
    public void readFile(){
        name = bank_file.next();
        acnt_num = bank_file.nextInt();
        phone = bank_file.next();
        ssn = bank_file.next();
        bal = bank_file.nextDouble();
        type = bank_file.next().charAt(0);
    }
    
    public void closeFile(){
        bank_file.close();
    }
    
    public double accountType(char typeCheck, double balanceCheck){ //checks the account type
        if (typeCheck == 'C') {
            Checking checkingAccount = new Checking();
            return checkingAccount.interest();
        }
        if (typeCheck == 'S') {
            Savings savingsAccount = new Savings();
            return savingsAccount.interest(balanceCheck);           
        }
                   
        if (typeCheck =='B') {
            Business businessAccount = new Business(); 
            return businessAccount.interest();
            }
        System.out.println("Error, account type not defined!");
        return -100; //shows error 
    }
    
    public double interestCalculator(double accountBalance, double intType){
        return accountBalance + accountBalance*intType;
    }
}
