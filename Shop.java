package Bookstore;

import java.util.*;

/**
 * Created by 777 on 07.03.2016.
 */
public class Shop {
    public final String[] columnNames = {"№", "Book","Date", "Quontity", "Client"};
    private TreeSet<Book> books = new TreeSet<Book>();
    private LinkedList<Purchase> purchases = new LinkedList<Purchase>();
    private LinkedList<Client> clients = new LinkedList<Client>();
    private LinkedList<Purchase> basket = new LinkedList<Purchase>();


   public TreeSet<Book> getBooks() {
        return books;
    }

    public LinkedList<Purchase> getPurchases() {
        return purchases;
    }

    public LinkedList<Client> getClients() {
        return clients;
    }

    public Shop(){
        getClients().add(Client.DefaultClient());
    }

    public LinkedList<Purchase> getBasket() {
        return basket;
    }

    public void addBook(Book book){
            Iterator<Book> i = books.iterator();
            while (i.hasNext()){
                Book b = i.next();
                if(b.equals(book)){
                    b.setQuontity(b.getQuontity() + book.getQuontity());
                    return;
                }
            }
            books.add(book);
    }

    public void sellBooksInBasket(){
        Iterator<Purchase> i = basket.iterator();
        Date date = new Date(System.currentTimeMillis());
        while (i.hasNext()){
            Purchase p = i.next();
            p.setDate(date);
            purchases.add(p);
        }
        basket.clear();
    }

    public void addClient(Client c){
        getClients().add(c);
    }
    public String[][] returnTable() {
        String[][] table = new String[this.getBasket().size()][5];

        for (int i = 0; i < this.getBasket().size(); i++) {
            String date = this.getBasket().get(i).getDate().toString();
            String name = this.getBasket().get(i).getBook().toString();
            String client = this.getBasket().get(i).getClient().toString();
            String quontity = this.getBasket().get(i).getBook().getQuontity() + "";
            table[i] = new String[]{(i + 1) + "", name, date, quontity, client};
        }
        if (this.getBasket().size() < 1) {
            table = new String[1][5];
            table[0] = new String[]{"None", "None", "None", "None", "None"};
        }
        return table;
    }
}
