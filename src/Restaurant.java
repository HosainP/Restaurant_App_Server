import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Restaurant implements Serializable {
    String name;
    String phoneNumber;
    String password;
    String label;
    double score;
    Address address;
    ArrayList<Food> foods;
    ArrayList<Comment> comments;

    Restaurant (){
        foods = new ArrayList<>();
        comments = new ArrayList<>();
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
