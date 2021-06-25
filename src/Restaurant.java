import java.util.ArrayList;

public class Restaurant {
    String name = ""; // setting is done
    String phoneNumber = ""; // setting is done
    String password = ""; // setting is done
    double score; // setting is done
    Address address; // setting is done
    ArrayList<Food> foods = new ArrayList<>(); // setting is done
    ArrayList<Comment> comments = new ArrayList<>(); // setting is done

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