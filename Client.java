package Bookstore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SplittableRandom;

/**
 * Created by 777 on 05.03.2016.
 */
public class Client {
    private String name;
    private String surname;
    private Boolean sex; //0 - Male, 1 - FeeMale
    private String email;
    private Boolean discountCard;
    private String numberDiscountCard;
    private int discount;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getDiscountCard() {
        return discountCard;
    }

    public String getNumberDiscountCard() {
        return numberDiscountCard;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setNumberDiscountCard(String numberDiscountCard) {
        this.numberDiscountCard = numberDiscountCard;
    }

    public void setDiscountCard(Boolean discountCard) {
        this.discountCard = discountCard;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Client(String name, String surname, Boolean sex){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        email = null;
        discountCard = true;
        numberDiscountCard = "Default DiscountCard";
        discount = 0;
    }

    public Client(String name, String surname, Boolean sex, String email){
        this(name, surname, sex);
        this.setEmail(email);
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyHHmm");
        this.setNumberDiscountCard(name.substring(0,1)+surname.substring(0,1)+sex.toString().substring(0,1) +
        s.format(d));
        this.setDiscount(10);
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname() + ", " + this.getNumberDiscountCard();
    }

    public static Client DefaultClient(){
        return new Client("Defauft", "Client", true);
    }
}
