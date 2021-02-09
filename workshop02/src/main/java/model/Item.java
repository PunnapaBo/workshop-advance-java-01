package model;

public class Item {
    private Book book;
    private int qty;

    public Item() {
    }

    public Item(Book book, int qty) {
        this.book = book;
        this.qty = qty;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isSame(String name) {
        boolean same = this.getBook().getName().equals(book.getName());
        qty++;
        return same;
    }
}
