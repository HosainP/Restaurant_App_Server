import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

class User implements Serializable {
     String name;
     String password;
     String phoneNumber;
     String gender;
     int balance;
     Address address;
     ArrayList<Restaurant> favoriteRestaurant;
     ArrayList <Comment> comments;
     ArrayList<Order> previousOrders;
     ArrayList<Order> activeOrders;
     ArrayList<Food> cart;

    public User(String name, String password, String phoneNumber, String gender, Address address) {
        this();
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.balance = 0;
        this.address = address;

    }

    public User() {
        favoriteRestaurant = new ArrayList<>();
        comments = new ArrayList<>();
        previousOrders = new ArrayList<>();
        activeOrders = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", balance=" + balance +
                ", address=" + address +
                '}';
    }
}

