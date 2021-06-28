import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    String year;
    String month;
    String day;
    String time; // num:num
    String userName;
    static int trackingNumber = 5000;
    Restaurant restaurant;
    int sum = 0;
    ArrayList<Food> orders;

    Order(String year,String month, String day, String time, Restaurant restaurant, ArrayList<Food> orders){
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
        this.restaurant = restaurant;
        this.orders = orders;
        this.userName = userName;
        for(int i=0; i<orders.size();i++){
            sum+=orders.get(i).price*orders.get(i).counter;
        }
        trackingNumber++;
    }

    Order(String year,String month, String day, String time, String userName, ArrayList<Food> orders){
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
        this.userName = userName;
        this.orders = orders;
        this.userName = userName;
        for(int i=0; i<orders.size();i++){
            sum+=orders.get(i).price*orders.get(i).counter;
        }
        trackingNumber++;
    }
    public String getDate(){
        return year+ "/" +month+ "/" +day;
    }
    int getTrackingNumber(){
        return trackingNumber;
    }
}