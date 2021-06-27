import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class RewriteRestaurant {
    Restaurant restaurant;
    String address;

    RewriteRestaurant(Restaurant restaurant, String address) {
        this.restaurant = restaurant;
        this.address = address;
    }

    void Rewrite() {
        //
        File nameOfRestaurant = new File(address + "\\name.txt");

        try { //making the name of the restaurant file.
            Writer writer = new FileWriter(address + "\\name.txt");
            writer.write(restaurant.name);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File passwordOfRestaurant = new File(address + "\\password.txt");

        try { //making the password of the restaurant file.
            Writer writer = new FileWriter(address + "\\password.txt");
            writer.write(restaurant.password);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File numberOfRestaurant = new File(address + "\\phoneNumber.txt");

        try { //making the phoneNumber of the restaurant file.
            Writer writer = new FileWriter(address + "\\phoneNumber.txt");
            writer.write(restaurant.phoneNumber);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File categoryOfRestaurant = new File(address + "\\foodCategory.txt");

        try { //making the foodCategory of the restaurant file.
            Writer writer = new FileWriter(address + "\\foodCategory.txt");
            writer.write(restaurant.label);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File scoreOfRestaurant = new File(address + "\\score.txt");

        try { //making the score of the restaurant file.
            Writer writer = new FileWriter(address + "\\score.txt");
            if (restaurant.score == 0.0) {
                writer.write("not rated yet.");
            } else {
                writer.write(String.valueOf(restaurant.score));
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File addressOfRestaurant = new File(address + "\\address.txt");

        try { //making the address of the restaurant file.
            Writer writer = new FileWriter(address + "\\address.txt");
            writer.write(restaurant.address.getAddressName() + ":" + restaurant.address.getLatitude() + ":" + restaurant.address.getLongitude());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File discountCodeOfRestaurant = new File(address + "\\discountCode.txt");

        try { //making the address of the restaurant file.
            Writer writer = new FileWriter(address + "\\discountCode.txt");
            writer.write(restaurant.discountCode);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //

        //
        File foodsFolder = new File(address + "\\Foods");
        for (Food f : restaurant.foods) {
            File file = new File(address + "\\Foods\\" + f.name + ".txt");
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                Writer writer = new FileWriter(address + "\\Foods\\" + f.name + ".txt");
                writer.write(f.numberOfSales + ":" + f.name + ":" + f.details + ":" + f.price + ":" + f.counter + ":" + f.label + ":" + f.isAvailable);
                writer.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //

        //
        File commentsFolder = new File(address + "\\Comments");
        for (int i = 1; i < restaurant.comments.size() + 1; i++) {
            File file = new File(address + "\\Comments\\comment" + i + ".txt");
            try{
                if(!file.exists()){
                    file.createNewFile();
                }
                Comment comment = restaurant.comments.get(i-1);
                Writer writer = new FileWriter(address + "\\Comments\\comment" + i + ".txt");
                writer.write(comment.text + ":"+ comment.answer + ":" + comment.star + ":" + comment.userName + ":" + comment.checked);
                writer.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        //
    }

}
