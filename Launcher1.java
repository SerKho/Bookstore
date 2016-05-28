package Bookstore;

/**
 * Created by 777 on 30.04.2016.
 */
public class Launcher1 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        InitShop(shop);
        ShopUI ui = new ShopUI(shop);
    }

    public static void InitShop(Shop shop){
        Book Book1 = new Book("Sherlok Holms", "Artur Konan Doil", Genre.DETECTIVE, 15.50, 50);
        shop.addBook(Book1);

        Book Book2 = new Book("Biology", "Irna Valerova", Genre.SCIENCE, 13.50, 2);
        shop.addBook(Book2);

        Book Book3 = new Book("C#", "Andrew Rikhter", Genre.COMPUTERS, 20.00, 8);
        shop.addBook(Book3);

        Client client1 = new Client("Semen", "Semenov", true, "homuch@bigmir.net");
        shop.addClient(client1);

        shop.getBasket().add(new Purchase(Book1, client1));
        shop.getBasket().add(new Purchase(Book3, client1));
    }
}
