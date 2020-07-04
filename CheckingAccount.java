import java.util.ArrayList;
public class CheckingAccount extends Account{
    private ArrayList<Integer> checkID;
    private ArrayList<Double> checkBalance;
    private ArrayList<Integer> removedcheckID;
    private ArrayList<Double> removedcheckBalance;
    private static int ID;
    public CheckingAccount(double _balance,Person _owners){
        super(_balance,_owners);
        checkID = new ArrayList<Integer>();
        checkBalance = new ArrayList<Double>();
        removedcheckID = new ArrayList<Integer>();
        removedcheckBalance = new ArrayList<Double>();
    }
    public boolean withdraw(double amount){
        if(super.balance - amount >= SavingsAccount.MINIMUM_BALANCE){
            super.balance -= amount;
            return true;
        }
        return false;
    }
    //attempt to withdraw money by writing a check
    public void writeCheck(double amount){
        if(this.withdraw(amount)){
            checkBalance.add(amount);
            checkID.add(ID);
            ID++;
        }
    }
    public void cancelCheck(int checkNumber){
        int position = -1;
        for (int i = 0; i < checkID.size(); i++){
            if(checkNumber == checkID.get(i)){
                position = i;
            }
        }
        super.balance += checkBalance.get(position);
        
        removedcheckBalance.add(checkBalance.get(position));
        removedcheckID.add(checkNumber);
        checkBalance.remove(position);
        checkID.remove(position);
    }
}
