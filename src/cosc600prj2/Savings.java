package cosc600prj2;

public class Savings extends IOaccounts{      
    
    public double getInterest(double a){
        double number = 5000;
        
        if (a > number)
                return .05;
        
        else return .04;
    }    
}
