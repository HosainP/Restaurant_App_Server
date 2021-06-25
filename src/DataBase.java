import java.io.File;
import java.io.*;
import java.util.*;

public class DataBase {
    public static Vector<Restaurant> restaurants = new Vector<>();
    public  ArrayList<User> users = new ArrayList<>();
    FileOutputStream fos = null;
    FileInputStream fis = null;
    File file = new File("C:\\Users\\Saeed\\Desktop\\users.txt");
    DataBase() throws FileNotFoundException {
        fos = new FileOutputStream(file, true);
        fis = new FileInputStream(file);
    }
    User findUser(String phoneNumber, String password){
        for (User user: users ) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    boolean addUser(String information) throws IOException {
        String[] inform = information.split(":::");
        String address = inform[4];
        Address personAddress = new Address(address.split("-")[0],Double.parseDouble(address.split("-")[1]), Double.parseDouble(address.split("-")[2]));
        User user = new User(inform[0], inform[2], inform[1], inform[3], personAddress);
        if (findUser(user.getPhoneNumber(), user.getPassword()) != null){
            return false;
        }
        users.add(user);
        System.out.println(user);
        fos = new FileOutputStream(file);
        writeFile();
        return true;
    }
    void readFile()  {
        try (ObjectInputStream ois = new ObjectInputStream(fis)){
            users = (ArrayList<User>)  ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
        }
    }
    void writeFile() throws IOException {
        fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }
    Restaurant findRestaurant (String phoneNumber){
        for (Restaurant restaurant:restaurants) {
            if (restaurant.phoneNumber.equals(phoneNumber)){
                return restaurant;
            }
        }
        return null;
    }
    User findUser (String phoneNumber){
        for (User user:users) {
            if (user.phoneNumber.equals(phoneNumber)){
                return user;
            }
        }
        return null;
    }

}
