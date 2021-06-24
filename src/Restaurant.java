import java.util.ArrayList;

public class Restaurant {
    String name;
    String phoneNumber;
    String password;
    double score;
    Address address;
    ArrayList<Food> foods = new ArrayList<>();
    ArrayList<Comment> comments = new ArrayList<>();
    // todo other parameters that a restaurant have
    //  for example food list.

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
