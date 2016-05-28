package Bookstore;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 777 on 05.03.2016.
 */
public class Purchase {
    private Date date;
    private Book book;
    private Client client;
    private double money;

    public Date getDate() {
        return date;
    }

    public Book getBook() {
        return book;
    }

    public Client getClient() {
        return client;
    }

    public double getMoney() {
        return money;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Purchase(Book book, Client client){
        date = new Date(System.currentTimeMillis());
        this.book = book;
        this.client = client;
        if(client.getDiscountCard()) {
            money = book.getPrice() * (100 - client.getDiscount()) / 100*book.getQuontity();
        }
        else{
            money = book.getPrice()*book.getQuontity();}
        }
    public String[] separate(){
        String[]res = new String[4];
        res[0] = date.toString();
        res[1] = book.toString();
        res[2] = client.toString();
        res[3] = book.getQuontity()+"";
        return res;
    }
}
