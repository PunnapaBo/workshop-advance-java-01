import model.Basket;

public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket,netPrice);
        int totalPrice = netPrice - maxDiscount;
        basket.setNetPrice(netPrice);
        basket.setDiscountPrice(totalPrice);
        // TODO
    }
}
