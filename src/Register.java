import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Register {
    Register(String phoneNumber, String name, String password, String foodCategory) {
        File RestaurantFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber);
        boolean dirCreated = RestaurantFolder.mkdir();
        if (dirCreated) {
            System.out.println("restaurant folder created.");
        }

        File nameOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\name.txt");
        try {
            nameOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nameOfRestaurant.exists()) {
            System.out.println("name file created.");
        }

        try { //making the name of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\name.txt");
            writer.write(name);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File passwordOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\password.txt");
        try {
            passwordOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (nameOfRestaurant.exists()) {
            System.out.println("password file created.");
        }

        try { //making the password of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\password.txt");
            writer.write(password);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File numberOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\phoneNumber.txt");
        try {
            numberOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (numberOfRestaurant.exists()) {
            System.out.println("phoneNumber file created.");
        }

        try { //making the phoneNumber of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\phoneNumber.txt");
            writer.write(phoneNumber);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File categoryOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\foodCategory.txt");
        try {
            categoryOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (categoryOfRestaurant.exists()) {
            System.out.println("foodCategory file created.");
        }

        try { //making the foodCategory of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\foodCategory.txt");
            writer.write(foodCategory);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File foodsFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Foods");
        boolean foodsCreated = foodsFolder.mkdir();
        if (foodsCreated) {
            System.out.println("foods folder created.");
        }

        // now we add the phone number and the password of the restaurant to the names file.
        File namesFile = new File("C:\\Users\\SaBa User\\IdeaProjects\\Restaurant App Server\\DataBase\\RestaurantNames.txt");
        try {
            Writer writer = new FileWriter(namesFile, true);
            writer.write(phoneNumber + ":" + password + ":::");
            writer.close();
            System.out.println("phoneNumber and password added to the names file.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
