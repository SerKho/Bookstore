package Bookstore;

/**
 * Created by 777 on 07.03.2016.
 */
public class Shop {
    private Book[] books = new Book[1000];
    private int booksInBase = 0;
    private Purchase[] purchases = new Purchase[100];
    private int purchasesInBase = 0;
    private Client[] clients = new Client[10];
    private int clientsInBase = 0;

    public int getBooksInBase() {
        return booksInBase;
    }

    public int getPurchasesInBase() {
        return purchasesInBase;
    }

    public int getClientsInBase() {
        return clientsInBase;
    }

    public Book[] getBooks() {
        return books;
    }

    public Purchase[] getPurchases() {
        return purchases;
    }

    public Client[] getClients() {
        return clients;
    }
}
