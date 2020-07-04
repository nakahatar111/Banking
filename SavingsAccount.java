import java.util.ArrayList;
public class SavingsAccount extends Account{
    private double interestRate;
    private ArrayList<Double> dailyBalances;
    public static final int MINIMUM_BALANCE=100;
    
    public SavingsAccount( double _balance,Person _owners){
        super(_balance, _owners);
        dailyBalances = new ArrayList<Double>();
    }
    public boolean withdraw(double amount){
        if(super.balance - amount >= MINIMUM_BALANCE){
            super.balance -= amount;
            return true;
        }
        return false;
    }  
    public void recordDailyBalance(){
        dailyBalances.add(super.balance);
    }
    public double projectBalance(double timeInYears){
        return Math.pow(super.balance*(1+(interestRate/12)),12*timeInYears);
    }// use the compound interest formula .  Assume that the bank compounds the balance monthly. To learn more about how compound interest really works, click here .
    public void updateInterestPayment(){
        double sum = 0;
        for (double i : dailyBalances){
            sum += i;
        }
        double average = sum/30;
        double interest = average*(1+interestRate);
    }// @ once a month update account based on average daily balances and interest rate
}