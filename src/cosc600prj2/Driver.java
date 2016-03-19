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

    public static void main(String[] args) {
          
          IOaccounts r = new IOaccounts(); //create new class object r to read variables from file 
          
          //check for how many accounts
          r.openFile();
          int length= r.accountCounter();
          r.closeFile();
          
          IOaccounts[] n = new IOaccounts[length];
          for(int i=0; i<length; i++){ //build an array of account objects
              n[i] = new IOaccounts();
          }
        
          // reopen and assign values to account objects
          r.openFile();
          for(int i=0; i<length; i++){
                        
              r.readFile();
              n[i].name = r.name;
              n[i].acnt_num = r.acnt_num;
              n[i].phone = r.phone;
              n[i].ssn =  r.ssn;
              n[i].bal = r.bal;
              n[i].type = r.type;
          }
          r.closeFile();
      
          for(int i=0; i<length; i++){ //call methods to calc close balance 
              n[i].close_bal = n[i].interestCalc(n[i].bal, n[i].accounttype(n[i].type, n[i].bal));
          }
          
          //testing
          System.out.println("Name\tAccount\t\tPhone\t\tSSN\t\tOpen Balance\tClose Balance\tType\n"); // Print header
          for(int i=0; i<length; i++){ //print all accounts
              System.out.println(n[i].name+"\t"+n[i].acnt_num+"\t"+n[i].phone+"\t"+n[i].ssn+"\t"+n[i].bal+"\t\t" + n[i].close_bal +"\t\t"+n[i].type);
          }
          
    }  
}
