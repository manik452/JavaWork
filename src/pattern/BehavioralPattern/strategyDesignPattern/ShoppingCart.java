package pattern.BehavioralPattern.strategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manik on 9/4/2018.
 */
public class ShoppingCart {

    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int calculateToatal(){
        int sum =0;

        for(Item item:this.items){
            sum+=item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentStrategy){
        int amount = calculateToatal();
        paymentStrategy.pay(amount);
    }
}
