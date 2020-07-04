public class CertificateOfDeposit extends SavingsAccount{
    public static final double EARLY_WITHDRAW_PENALTY= 200;
    public CertificateOfDeposit( double _balance, Person _owners){
        super(_balance,_owners);
    }
    public boolean withdraw(double amount , boolean isEarly ){
        if(this.withdraw(amount)){
            if (isEarly)
                super.balance -= EARLY_WITHDRAW_PENALTY;
        }
        return false;
    }
}