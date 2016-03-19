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
    
    public int countAccounts(){
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
    
    //checks the account type
    public double checkAccountType(char typeCheck, double balanceCheck) throws Exception{ 
    	
    	switch(typeCheck){
    		case 'C': 
    			Checking checkingAccount = new Checking(); 
    			return checkingAccount.getInterest();
    		case 'S': 
    			Savings savingsAccount = new Savings();
    			return savingsAccount.getInterest(balanceCheck);   
    		case 'B':
    			 Business businessAccount = new Business(); 
    	         return businessAccount.getInterest();
    		default: throw new Exception("Error Account Type not defined");
    	}
    }
    
    public double computeInterest(double accountBalance, double intType){
        return accountBalance + accountBalance*intType;
    }
}
