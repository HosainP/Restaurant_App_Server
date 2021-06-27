
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RestaurantListForServer implements Serializable {

    static ArrayList<Restaurant> makeArrayList() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        String theAddress = Constants.hDataBaseAddress + "\\Restaurants\\";
        File file = new File(theAddress);
        String[] fileNames = file.list();
        for (String str : fileNames) {
            String resAddress = theAddress + str;
            Restaurant r = new Restaurant();
            setName(resAddress, r);
            setPhoneNumber(resAddress, r);
            setPassword(resAddress, r);
            setScore(resAddress, r);
            setFoods(resAddress + "\\Foods", r);
            setComments(resAddress + "\\Comments", r);
            restaurants.add(r);
        }
        return restaurants;
    }

    static void setName(String theAddress, Restaurant restaurant) {
        File name = new File(theAddress + "\\name.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            restaurant.name = restaurant.name + scanner.next();
        }
//        System.out.println("name is set: " + restaurant.name);
    }

    static void setPhoneNumber(String theAddress, Restaurant restaurant) {
        File phoneNumber = new File(theAddress + "\\phoneNumber.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(phoneNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        restaurant.phoneNumber = scanner.next();

//        System.out.println("phoneNumber is set: " + restaurant.phoneNumber);
    }

    static void setPassword(String theAddress, Restaurant restaurant) {
        File password = new File(theAddress + "\\password.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            restaurant.password = restaurant.password + scanner.next();
        }
//        System.out.println("password is set: " + restaurant.password);
    }

    static void setScore(String theAddress, Restaurant restaurant) {
        File score = new File(theAddress + "\\score.txt");
        String Score = "";
        Scanner scanner = null;
        try {
            scanner = new Scanner(score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            Score = Score + scanner.next();
        }

        if (Score.equals("notratedyet.")) {
            restaurant.score = 0;
        } else {
            restaurant.score = Double.parseDouble(Score);
        }

//        System.out.println("score is set: " + restaurant.score);
    }

    static void setAddress(String theAddress) {
        File address = new File(theAddress + "\\address.txt");
        String Address = "";
        Scanner scanner = null;
        try {
            scanner = new Scanner(address);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            Address = Address + scanner.next() + " ";
        }

        // todo now i have the information of the address in a string
        //  but we have to cast it to an address.

        System.out.println("address is set: " + Address);
    }

    static void setFoods(String theAddress, Restaurant restaurant) {
        File file = new File(theAddress);
        String[] fileNames = file.list();
//        System.out.println("foods list: " + Arrays.toString(fileNames)); // it's good.
        for (String name : fileNames) {
            String foodAddress = theAddress + "\\" + name;
            File foodFile = new File(foodAddress);
            Scanner scanner = null;
            try {
                scanner = new Scanner(foodFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String foodInfo = "";
            while (scanner.hasNext()) {
                foodInfo = foodInfo + " " + scanner.next();
            }
            String[] parts = foodInfo.split(":");
            restaurant.foods.add(new Food(Integer.parseInt(parts[0].trim()), parts[1].trim(), parts[2].trim(), Integer.parseInt(parts[3].trim()), Integer.parseInt(parts[4].trim()), parts[5].trim(), parts[6]));
        }
//        System.out.println("food list is set: " + restaurant.foods);
    }

    static void setComments(String theAddress, Restaurant restaurant) {
        File file = new File(theAddress);
        String[] fileNames = file.list();
        for (String name : fileNames) {
            String commentAddress = theAddress + "\\" + name;
            File commentFile = new File(commentAddress);
            Scanner scanner = null;
            try {
                scanner = new Scanner(commentFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String commentInfo = "";
            while (scanner.hasNext()) {
                commentInfo = commentInfo + " " + scanner.next();
            }
            String[] parts = commentInfo.split(":");
            boolean checked = false;
            if (parts[4].equals("true"))
                checked = true;
            restaurant.comments.add(new Comment(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()), parts[3], checked));
        }
//        System.out.println("comment list is set: " + restaurant.comments);
    }
}