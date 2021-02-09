import calculator.DiscountCalculator;
import calculator.PriceCalculator;
import model.Basket;
import model.Book;
import model.Item;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket,netPrice);
        int totalPrice = netPrice - maxDiscount;
        basket.setNetPrice(netPrice);
        basket.setDiscountPrice(totalPrice);
        // TODO
    }
//    public Map<String, Integer> countTitle(Basket basket){
//        Map<String, Integer> groupByTitle = new HashMap<>();
//        for(Item item :basket.getBooks()){
//            String name = item.getBook().getName();
//            if(groupByTitle.keySet().contains(name)){
//                int quantity = groupByTitle.get(name);
//                groupByTitle.put(name,quantity);
//            }
//            else{
//                groupByTitle.put(name,1);
//            }
//
//        }
//        return groupByTitle;
//    }
}
