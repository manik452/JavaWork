package pattern.BehavioralPattern.strategyDesignPattern;

/**
 * Created by Manik on 9/4/2018.
 */
public class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String CardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        CardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount+"paid with credit/debit card");
    }
}
