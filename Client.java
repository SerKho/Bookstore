package Bookstore;

import java.util.SplittableRandom;

/**
 * Created by 777 on 05.03.2016.
 */
public class Client {
    private String name;
    private String surname;
    private Boolean sex; //0 - Male, 1 - FeeMale
    private String email;
    private Purchase[] purcases = new Purchase[10];
    private int numberOfPurchases;
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

    public Purchase[] getPurchases() {
        return purcases;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
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

    public void updatePurchases(Purchase purchase){
        if (purchase != null) {
            if(numberOfPurchases>=(purcases.length-1)){
                Purchase[] temp = new Purchase[(int)(purcases.length*1.2)];
                System.arraycopy(purcases, 0, temp, 0, purcases.length);
                purcases = temp;
            }
            purcases[numberOfPurchases] = purchase;
            numberOfPurchases++;
        }
    }

    public Client(String name, String surname, Boolean sex){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }
}
