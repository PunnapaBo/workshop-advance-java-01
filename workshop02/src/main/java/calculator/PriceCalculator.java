package calculator;

import model.Basket;
import model.Item;

public class PriceCalculator {

    public static int get(Basket basket) {
        // Logic
        int price = 0;
        for ( Item item: basket.getBooks()){
            price += item.getBook().getPrice() * item.getQty();
        }
        return price*100;
    }
}
