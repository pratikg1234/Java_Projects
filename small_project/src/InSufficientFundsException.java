public class InSufficientFundsException extends Exception {
    private double amount;
 
    public InSufficientFundsException(double amount) {
        this.amount = amount;
    }
 
    @Override
    public String toString() {
        return "funds not available " + amount;
    }
}