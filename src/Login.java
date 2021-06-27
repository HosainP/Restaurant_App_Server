
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Login implements Serializable {

    private Restaurant restaurant = new Restaurant();
    boolean isAccepted = false;

    Login(String phoneNumber, String password, DataOutputStream dos) {
        File names = new File(Constants.hDataBaseAddress + "\\RestaurantNames.txt");
        String allTheInformation = "";
        String theAddress = "";

        Vector<RestaurantNumAndPass> restaurants = new Vector<>();

        Scanner input = null;
        try {
            input = new Scanner(names);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (input.hasNext()) {
            allTheInformation = allTheInformation + " " + input.next();
        }

        String[] splitting_restaurants = allTheInformation.split(":::");
        for (int i = 0; i < splitting_restaurants.length; i++) {
            String[] info = splitting_restaurants[i].split(":");
            restaurants.add(new RestaurantNumAndPass(info[0].trim(), info[1].trim()));
        } // works properly.

        boolean isInputTrue = false;
        for (RestaurantNumAndPass r : restaurants) {
            if (r.num.equals(phoneNumber) && r.pass.equals(password)) {
                isInputTrue = true;
                break;
            }
        }
        try {
            if (isInputTrue) {
                this.isAccepted = true;
            } else {
                this.isAccepted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        File file = new File(Constants.hDataBaseAddress + "\\Restaurants");
        String[] fileNames = file.list();
        for (String s : fileNames) {
            if (s.contains(phoneNumber)) {
                theAddress = s;
            }
        }
        theAddress = Constants.hDataBaseAddress + "\\Restaurants\\" + theAddress;

        setName(theAddress);
        setPhoneNumber(theAddress);
        setPassword(theAddress);
        setScore(theAddress);
        setAddress(theAddress);
        setLabel(theAddress);
        setDiscountCode(theAddress);
        setFoods(theAddress + "\\Foods");
        setComments(theAddress + "\\Comments");

    }

    void setName(String theAddress) {
        File name = new File(theAddress + "\\name.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.restaurant.name = "";
        while (scanner.hasNext()) {
            this.restaurant.name = this.restaurant.name + scanner.next();
        }
        System.out.println("name is set: " + this.restaurant.name);
    }

    void setPhoneNumber(String theAddress) {
        File phoneNumber = new File(theAddress + "\\phoneNumber.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(phoneNumber);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.restaurant.phoneNumber = scanner.next();

        System.out.println("phoneNumber is set: " + this.restaurant.phoneNumber);
    }

    void setPassword(String theAddress) {
        File password = new File(theAddress + "\\password.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.restaurant.password = "";
        while (scanner.hasNext()) {
            this.restaurant.password = this.restaurant.password + scanner.next();
        }
        System.out.println("password is set: " + this.restaurant.password);
    }

    void setScore(String theAddress) {
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
            this.restaurant.score = 0;
        } else {
            this.restaurant.score = Double.parseDouble(Score);
        }

        System.out.println("score is set: " + this.restaurant.score);
    }

    void setAddress(String theAddress) {
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

    void setLabel(String theAddress) {
        File label = new File(theAddress + "\\foodCategory.txt");
        String Label = "";
        Scanner scanner = null;
        try {
            scanner = new Scanner(label);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            Label = Label + scanner.next() + " ";
        }

        this.restaurant.label = Label;

        System.out.println("label is set: " + Label);
    }

    void setDiscountCode(String theAddress) {
        File discountCode = new File(theAddress + "\\discountCode.txt");
        String DiscountCode = "";
        Scanner scanner = null;
        try {
            scanner = new Scanner(discountCode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            DiscountCode = DiscountCode + scanner.next() + " ";
        }

        this.restaurant.discountCode = DiscountCode;

        System.out.println("discountCode is set: " + DiscountCode);
    }

    void setFoods(String theAddress) {
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
            this.restaurant.foods.add(new Food(Integer.parseInt(parts[0].trim()), parts[1].trim(), parts[2].trim(), Integer.parseInt(parts[3].trim()), Integer.parseInt(parts[4].trim()), parts[5].trim(), parts[6]));
        }
        System.out.println("food list is set: " + this.restaurant.foods);
    }

    void setComments(String theAddress) {
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
            this.restaurant.comments.add(new Comment(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()), parts[3], checked));
        }
        System.out.println("comment list is set: " + this.restaurant.comments + " - toString method is not right.");
    }

    Restaurant getRestaurant() {
        return this.restaurant;
    }

    String getName() {
        return this.restaurant.name;
    }

    String getPhoneNumber() {
        return this.restaurant.phoneNumber;
    }

    String getPassword() {
        return this.restaurant.password;
    }

    String getScore() {
        return String.valueOf(this.restaurant.score);
    }

    String getAddress() {
        return this.restaurant.address.toString(); //todo it's wrong
    }

    String getFoods() {
        String allOfFoods = "";
        for (Food f : this.restaurant.foods) {
            String thisFood = "";

        }
        return allOfFoods; //todo
    }

    String getComments() {
        return ""; //todo
    }
}

class RestaurantNumAndPass implements Serializable {
    String num;
    String pass;

    RestaurantNumAndPass(String name, String pass) {
        this.num = name;
        this.pass = pass;
    }
}