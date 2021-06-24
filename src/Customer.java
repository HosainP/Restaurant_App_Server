import java.io.Serializable;
import java.util.ArrayList;

class User implements Serializable {
    private String name;
    private String password;
    private String phoneNumber;
    private String gender;
    private int balance;
    private Address address;


    public User(String name, String password, String phoneNumber, String gender, Address address) {
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.balance = 0;
        this.address = address;

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

