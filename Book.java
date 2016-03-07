package Bookstore;

/**
 * Created by 777 on 05.03.2016.
 */
public class Book {
    private String name;
    private String author;
    private Genre genre;
    private int quontity;
    private double price;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getQuontity() {
        return quontity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuontity(int quontity) {
        this.quontity = quontity;
    }

    public Book(String name, String author, Genre genre, double price, int quontity){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.quontity = quontity;
    }
}
