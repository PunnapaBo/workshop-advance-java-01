import model.Basket;
import model.Book;
import model.BookBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {
    @Test
    public void buy_1_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new BookBuilder().chooseBook("Potter 1").build();
        basket.addBook(book1);

        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 800, discountPrice 800 - 0%
        assertEquals(800, basket.getNetPrice()); // 8.00
        assertEquals(800, basket.getDiscountPrice()); // 8.00
    }
    @Test
    public void buy_2_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new BookBuilder().chooseBook("Potter 1").build();
        Book book2 = new BookBuilder().chooseBook("Potter 2").build();
        basket.addBook(book1);
        basket.addBook(book2);

        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 1600, discountPrice 1600 - 5%
        assertEquals(1600, basket.getNetPrice()); // 8.00
        assertEquals(1520, basket.getDiscountPrice()); // 8.00
    }

    @Test
    public void buy_3_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new BookBuilder().chooseBook("Potter 1").build();
        Book book2 = new BookBuilder().chooseBook("Potter 2").build();
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
        assertEquals(2400, basket.getNetPrice()); // 24.00
        assertEquals(2160, basket.getDiscountPrice()); // 21.60
    }

}