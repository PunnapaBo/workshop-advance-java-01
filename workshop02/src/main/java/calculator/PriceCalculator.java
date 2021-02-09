package calculator;

import model.Basket;
import model.Book;

public class PriceCalculator {

    public static int get(Basket basket) {
        // Logic
        int price = 0;
        for ( Book book: basket.getBooks()){
            price += book.getPrice();
        }
        return price*100;
    }
}
