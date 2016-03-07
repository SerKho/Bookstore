package Bookstore;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 777 on 07.03.2016.
 */
public class Service {
    public static void prices(Shop shop){
        System.out.println("------------- Books prices -------------");
        for(int i=0; i<shop.getBooksInBase(); i++){
            System.out.println(i+1+". Book name: " + shop.getBooks()[i].getName() + ", author: " +
                    shop.getBooks()[i].getAuthor() + ", price: " + shop.getBooks()[i].getPrice());
        }
        System.out.println("-------------           -------------");
    }

    public static void quontityAwaliable(Shop shop){
        System.out.println("------------- Books quontity -------------");
        for(int i=0; i<shop.getBooksInBase(); i++){
            System.out.println(i+1+". Book name: " + shop.getBooks()[i].getName() + ", author: " +
                    shop.getBooks()[i].getAuthor() + ", quontity: " + shop.getBooks()[i].getQuontity());
        }
        System.out.println("-------------           -------------");
    }

    public static void purchasesForLastSevenDays(Shop shop) {
        Date thisDay = new Date(System.currentTimeMillis());
        int num = 1;
        for (int j = 0; j < 8; j++) {
            int sum = 0;
            for (int i = shop.getPurchasesInBase() - 1; i > 0; i--) {
                if ((dateFormat(thisDay) - j) == dateFormat(shop.getPurchases()[i].getDate())) {
                    sum += shop.getPurchases()[i].getBook().getQuontity();
                }
                if((dateFormat(thisDay) - j) > dateFormat(shop.getPurchases()[i].getDate())){
                    break;
                }
            }
            System.out.println((dateFormat(thisDay) - j) + ":" + sum);
        }
    }

    public static void todaysTransactionList(Shop shop){
        Date thisDay = new Date(System.currentTimeMillis());
        System.out.println("№    Client     Book name     Price     Quontity");
        int number = 0;
        int purchase=0;
        int books = 0;
        int money =0;
        for (int i = shop.getPurchasesInBase() - 1; i > 0; i--) {
            if ((dateFormat(thisDay) == dateFormat(shop.getPurchases()[i].getDate()))) {
                number++;
                purchase++;
                books+=shop.getPurchases()[i].getBook().getQuontity();
                money+=shop.getPurchases()[i].getMoney();
                System.out.println(number+"    "+shop.getPurchases()[i].getClient().getName()+ "   " +
                        shop.getPurchases()[i].getBook().getName()+ "   " +
                        shop.getPurchases()[i].getBook().getPrice()+ "   " +
                        shop.getPurchases()[i].getBook().getQuontity());
            }
            if ((dateFormat(thisDay) > dateFormat(shop.getPurchases()[i].getDate()))) {
                break;
            }

            }
        System.out.println("Resume: " + purchase + " purchases, money " + money + ", books saled " + books);
    }

    public static Book[] category(Shop shop, Genre genre){
        Book[]books = new Book[shop.getBooksInBase()];
        int i = 0;
        for(int j = 0; j<shop.getBooksInBase(); j++){
            if (shop.getBooks()[j].getGenre().equals(genre)) {
                books[i] = shop.getBooks()[j];
                i++;
            }
        }
        return books;
    }

public static int dateFormat(Date d){
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    return Integer.parseInt((dateFormat.format(d)).toString());
}

}
