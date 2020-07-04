import java.util.ArrayList;
public class Bank
{
    ArrayList<Account> accounts;
    ArrayList<Account> sort;
    public Bank(Account _accounts){
        accounts = new ArrayList<Account>();
        accounts.add(_accounts);
    }
    
    public Bank(int accountNumber){
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber)
                accounts.remove(account);
        }
    }
    
    public Bank(Person owner){
        for(Account account : accounts)
            for(Person people: account.getOwners())
                if(people.equals(owner))
                    accounts.remove(account);
    }
    
    ArrayList<Person> topAccountOwners(double cutoff){
        ArrayList<Person> topAccount = new ArrayList<Person>();
        for(Account account : accounts)
            if(account.getCurrentBalance() >= cutoff)
                topAccount.addAll(account.getOwners());
        return topAccount;
    }
    
    void nightlyUpdate(){
        for(Account account : accounts)
            if (account instanceof SavingsAccount)
                ((SavingsAccount)account).recordDailyBalance();
    }
    
    Account topBalance(){
        Account top = accounts.get(0);
        for(Account account : accounts)
            if(top.getCurrentBalance() < account.getCurrentBalance())
                top = account;
        return top;
    }
    
    Account[] allWithinRange(double min, double max){
        int counter = 0;
        int position = 0;
        for(Account account : accounts)
            if(account.getCurrentBalance() <= max && account.getCurrentBalance() >= min)
                counter++;
        Account[] rangeAccount = new Account[counter];
        for(Account account : accounts){
            if(account.getCurrentBalance() <= max && account.getCurrentBalance() >= min){
                rangeAccount[position] = account;
                position++;
            }
        }
        return rangeAccount;
    }
    
    boolean transfer( double amount, int accountIdFrom , int accountIdTo){
        Account From = null;
        Account To = null;
        for(Account account : accounts)
            if(account.getAccountNumber() == accountIdFrom)
                From = account;
        for(Account account : accounts)
            if(account.getAccountNumber() == accountIdTo)
                To = account;
        if(From.getCurrentBalance()-amount >= SavingsAccount.MINIMUM_BALANCE){
            To.deposit(amount);
            return From.withdraw(amount);
        }
        return false;
    }
    
    void monthlyUpdate(){
        for(Account account : accounts)
            if (account instanceof SavingsAccount)
                ((SavingsAccount)account).updateInterestPayment();
    }
    
    ArrayList<Account> sortByAmount(){
        sort = new ArrayList<Account>();
        for(Account copy:accounts)
            sort.add(copy);
        
        for(int j = 0 ; j < sort.size()-1; j++){
            int base = j;
            int max = j;
            for(int i = j+1 ; i < sort.size(); i++){
                if(sort.get(max).getCurrentBalance() < sort.get(i).getCurrentBalance()){
                    max = i;
                }
            }
            swaplocation(base,max);
        }
        return sort;
    }  
    
    public void swaplocation(int place1 ,  int place2 ){
        Account placeholder = sort.get(place1);
        int position = place2;
        sort.set(place1, sort.get(place2));
        sort.set(position, placeholder);
    }
}
