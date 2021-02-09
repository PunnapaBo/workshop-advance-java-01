public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket);
        int totalPrice = netPrice - maxDiscount;
        // TODO
    }
}
