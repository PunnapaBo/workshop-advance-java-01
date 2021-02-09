package model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Item> books = new ArrayList<>();
    private int netPrice;
    private int discountPrice;

    public void addBook(Book book) {
        //BigO(n)
        boolean isExisted = false;
        for(Item item : books){

            if(item.isSame(book.getName())){
                isExisted = true;
                break;
            }

        }
        if(!isExisted){
            Item newItem = new Item(book,1);
            books.add(newItem);
        }

    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public List<Item> getBooks() {
        return books;
    }
}
