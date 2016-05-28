package Bookstore;

/**
 * Created by 777 on 21.02.2016.
 */
public enum Genre {
    FANTASY(0), FOOD(1), COMPUTERS(2), FICTION(3), HISTORY(4), SCIENCE(5), DETECTIVE(6), KIDS(7);
    int id;
    private Genre(int id){
        this.id = id;
        getId();
    }
    private int getId(){
        return id;
    }
}
