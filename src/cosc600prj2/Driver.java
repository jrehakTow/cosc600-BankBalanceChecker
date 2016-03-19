/*
 * COSC 600                        Project 2
 * James Rehak                     9-26-14
 * Program Name: Bank Balance Closer
 * Read in data from file into an array of account objects
 * Check account type element and and create object account type
 * Calc interest and add to closing balance element
 * Print all account elements to console. 
 */

package cosc600prj2;

/**
 *
 * @author James Rehak
 */
public class Driver {

    public static void main(String[] args) throws Exception {
          
          IOaccounts read = new IOaccounts(); //create new class object r to read variables from file 
          
          //check for how many accounts
          read.openFile();
          int length = read.countAccounts();
          read.closeFile();
          
          IOaccounts[] account = new IOaccounts[length];
          for(int i=0; i<length; i++){ //build an array of account objects
              account[i] = new IOaccounts();
          }
        
          // reopen and assign values to account objects
          read.openFile();
          for(int i=0; i<length; i++){
                        
              read.readFile();
              account[i].name = read.name;
              account[i].acnt_num = read.acnt_num;
              account[i].phone = read.phone;
              account[i].ssn =  read.ssn;
              account[i].bal = read.bal;
              account[i].type = read.type;
          }
          read.closeFile();
      
          for(int i=0; i<length; i++){ //call methods to calc close balance 
              account[i].close_bal = account[i].computeInterest(account[i].bal, account[i].checkAccountType(account[i].type, account[i].bal));
          }
          
          //testing
          System.out.println("Name\tAccount\t\tPhone\t\tSSN\t\tOpen Balance\tClose Balance\tType\n"); // Print header
          for(int i=0; i<length; i++){ //print all accounts
              System.out.println(account[i].name+"\t"+account[i].acnt_num+"\t"+account[i].phone+"\t"+account[i].ssn+"\t"+account[i].bal+"\t\t" + account[i].close_bal +"\t\t"+account[i].type);
          }
    }  
}
