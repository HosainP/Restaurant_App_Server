import java.util.ArrayList;
import java.util.Vector;

public class Restaurant {
    String name;
    String phoneNumber;
    String password;
    String label;
    double score;
    Address address;
    Vector<Food> foods;
    Vector<Comment> comments;

    Restaurant (){
        foods = new Vector<>();
        comments = new Vector<>();
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", address=" + address +
                ", foods=" + foods +
                ", comments=" + comments +
                '}';
    }
}
