
import java.io.*;

public class Register implements Serializable {
    Register(String phoneNumber, String name, String password, String foodCategory) {
        //
        File RestaurantFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber);
        boolean dirCreated = RestaurantFolder.mkdir();
        if (dirCreated) {
            System.out.println("restaurant folder created.");
        }
        //

        //
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
        //

        //
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
        //

        //
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
        //

        //
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
        //

        //
        File scoreOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\score.txt");
        try {
            scoreOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (scoreOfRestaurant.exists()) {
            System.out.println("score file created.");
        }

        try { //making the score of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\score.txt");
            writer.write("not rated yet.");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File addressOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\address.txt");
        try {
            addressOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addressOfRestaurant.exists()) {
            System.out.println("address file created.");
        }

        try { //making the address of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\address.txt");
            writer.write("this file should contain address of the resturant.");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File discountCodeOfRestaurant = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\discountCode.txt");
        try {
            discountCodeOfRestaurant.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (discountCodeOfRestaurant.exists()) {
            System.out.println("discountCode file created.");
        }

        try { //making the address of the restaurant file.
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\discountCode.txt");
            writer.write("discountCode");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File foodsFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Foods");
        boolean foodsCreated = foodsFolder.mkdir();
        if (foodsCreated) {
            System.out.println("foods folder created.");
        }
        //

        //
        File commentsFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Comments");
        boolean commentsCreated = commentsFolder.mkdir();
        if (commentsCreated) {
            System.out.println("comments folder created.");
        }
        //


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