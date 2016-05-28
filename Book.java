package Bookstore;

import java.util.Comparator;

/**
 * Created by 777 on 05.03.2016.
 */
public class Book implements Comparable{
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

//    @Override
//    public int compare(Object o1, Object o2) {
//        Book b1 = (Book)o1;
//        Book b2 = (Book)o2;
//        if(b1.getName().compareTo(b2.getName())>0){
//            return 1;
//        }
//        else if(b1.getName().compareTo(b2.getName())<0){
//            return -1;
//        }
//        else{
//            if(b1.getAuthor().compareTo(b2.getAuthor())>0){
//                return 1;
//            }
//            else if(b1.getAuthor().compareTo(b2.getAuthor())<0){
//                return -1;
//            }
//            else{
//                 return 0;
//            }
//        }
//    }

    @Override
    public int compareTo(Object o) {
        Book b1 = (Book)o;
        if(this.getName().compareTo(b1.getName())>0){
            return 1;
        }
        else if(this.getName().compareTo(b1.getName())<0){
            return -1;
        }
        else{
            if(this.getAuthor().compareTo(b1.getAuthor())>0){
                return 1;
            }
            else if(this.getAuthor().compareTo(b1.getAuthor())<0){
                return -1;
            }
            else{
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book)obj;
        if (this.getName().equalsIgnoreCase(book.getName()) && this.getAuthor().equalsIgnoreCase(book.getAuthor())) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getAuthor();
    }
}
