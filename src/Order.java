import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Order {
    Data dateTime;
    static int trackingNumber = 5000;
    Restaurant restaurant;
    int sum = 0;
    ArrayList<Food> orders = new ArrayList<>();
    int tNumber;
    Order(Data dateTime, Restaurant restaurant, ArrayList<Food> orders){
        this.dateTime = dateTime;
        this.restaurant = restaurant;
        this.orders = orders;
        for(int i=0; i<orders.size();i++){
            sum+=orders.get(i).price*orders.get(i).counter;
        }
        trackingNumber++;
        tNumber = trackingNumber;
    }
    int getTrackingNumber(){
        return tNumber;
    }
}
