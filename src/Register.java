
import java.io.*;
import java.util.Scanner;

public class Register implements Serializable {
    Register(String phoneNumber, String name, String password, String foodCategory) throws FileNotFoundException {

        // now we add the phone number and the password of the restaurant to the names file.
        File namesFile = new File("C:\\Users\\SaBa User\\IdeaProjects\\Restaurant App Server\\DataBase\\RestaurantNames.txt");
        String oldFile = "";
        Scanner scanner = new Scanner(namesFile);
        while (scanner.hasNext()) {
            oldFile = oldFile + scanner.next();
        }
        oldFile = oldFile + phoneNumber + ":" + password + ":::";
        try {
            Writer writer = new FileWriter(namesFile);
            writer.write(oldFile);
            writer.close();
            System.out.println("phoneNumber and password added to the names file.");
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            writer.write("0.0");
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
            writer.write("here:0.0:0.0");
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

        File theFood = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Foods\\food1.txt");
        try {
            theFood.createNewFile();
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Foods\\food1.txt");
            writer.write("53:food1:this is the details:25000:123:this is label:true");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        //

        //
        File commentsFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Comments");
        boolean commentsCreated = commentsFolder.mkdir();
        if (commentsCreated) {
            System.out.println("comments folder created.");
        }

        File theComment = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Comments\\comment1.txt");
        try {
            theComment.createNewFile();
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Comments\\comment1.txt");
            writer.write("food is good:thanks for your comment:5:Hosain Pishgahi:true");
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
        //

        //
        File ordersFolder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Orders");
        boolean ordersCreated = ordersFolder.mkdir();
        if (ordersCreated) {
            System.out.println("orders folder created.");
        }

        File theOrder = new File(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Orders\\order1.txt");
        try {
            theOrder.createNewFile();
            Writer writer = new FileWriter(Constants.hDataBaseAddress + "\\Restaurants\\" + name + "-" + phoneNumber + "\\Orders\\order1.txt");
            writer.write("2020:::12:::30:::15:::30:::username:::20:kebab:soltani:5000:35:kebabi:true::35:jooje:chicken:52000:25:foodLabel:false::");
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
        //




    }
}