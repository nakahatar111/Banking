import java.util.ArrayList;
public abstract class Account{
    private static int nextAccountNum;
    private static int parentCompanyCode = 12810;
    private int  accountNumber;
    protected  double  balance;
    protected  ArrayList<Person> owners;
    public Account(double _balance,Person _owner)
    {
        owners = new ArrayList<Person>();
        this.balance = _balance;
        owners.add(_owner);
    }
    public static int getParentCode(){
        return parentCompanyCode;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public void deposit(double amount){
        this.balance += amount;
    }
    public double getCurrentBalance(){
        return this.balance;
    }
    public abstract boolean withdraw(double amount);
    public boolean equals(Account other){
        return accountNumber == other.accountNumber;
    }
    public String toString(){
        return "Account[ Person: "+owners+ " Balance:" + balance+ " AccountNumber: "+ accountNumber +" ]";
    }
    public int comparesTo(Account other) { 
        return this.accountNumber- other.accountNumber;
    }
    public void addOwner(Person p){
        owners.add(p);
        nextAccountNum++;
        this.accountNumber = nextAccountNum;
    }
    public ArrayList<Person> getOwners(){
        return owners;
    }
    public Person remove( Person p){
        owners.remove(p);
        return p;
    }
} 
