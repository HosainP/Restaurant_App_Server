
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Restaurant implements Serializable {
    String name = "";
    String phoneNumber = "";
    String password = "";
    String label = "";
    double score = 0.0;
    Address address = new Address("name", 0.0, 0.0);
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<Comment> comments = new ArrayList<>();
    String discountCode = "";

    Restaurant() {
        foods = new ArrayList<>();
        comments = new ArrayList<>();
    }

    Restaurant(String name, String phoneNumber, String password, double score, ArrayList<Food> foods, ArrayList<Comment> comments) { //todo address
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.score = score;
        this.foods = foods;
        this.comments = comments;
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

