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
    
    public double accounttype(char typeCK, double balCK){ //checks the account type
        if (typeCK == 'C') {
            Checking c = new Checking();
            return c.interest();
        }
        if (typeCK == 'S') {
            Savings s = new Savings();
            return s.interest(balCK);           
        }
                   
        if (typeCK =='B') {
            Business b = new Business(); 
            return b.interest();
            }
        System.out.println("Error, account type not defined!");
        return -100; //shows error 
    }
    
    public double interestCalc(double b, double intType){
        return b + b*intType;
    }
}
