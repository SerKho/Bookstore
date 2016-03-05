package Bookstore;

/**
 * Created by 777 on 05.03.2016.
 */
public class Book {
    private String name;
    private String author;
    private Genre genre;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, String author, Genre genre, double price){
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }
}
