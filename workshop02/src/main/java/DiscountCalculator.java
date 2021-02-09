import model.Basket;

public class DiscountCalculator {
    public static int get(Basket basket, int netPrice) {
        // Logic
        int numOfBook = basket.getBooks().size();
        double discountPercent = getDiscountPercent(numOfBook);
        double discountPrice = (netPrice*discountPercent);

        return (int)discountPrice;
    }

    private static double getDiscountPercent(int numOfBook) {
        switch (numOfBook){
            case 1:
                return 0;
            case 2:
                return (double) 5/100;
            case 3:
                return (double) 10/100;
            case 4:
                return (double) 20/100;
            case 5:
                return (double) 25/100;

        }
        return 0;
    }
}
