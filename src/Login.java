import java.io.DataOutputStream;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Login {
    Login(String phoneNumber, String password, DataOutputStream dos){
        File names = new File(Constants.hDataBaseAddress + "\\RestaurantNames.txt");
        String allTheInformation = "";

        Vector<RestaurantNumAndPass> restaurants = new Vector<>();

        Scanner input = null;
        try{
            input = new Scanner(names);
        }catch (Exception e){
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
        for (RestaurantNumAndPass r : restaurants){
            if (r.num.equals(phoneNumber) && r.pass.equals(password)){
                isInputTrue = true;
                break;
            }
        }
        try{
            if (isInputTrue) {
                dos.writeBytes("true");
            }else{
                dos.writeBytes("false");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class RestaurantNumAndPass {
    String num;
    String pass;

    RestaurantNumAndPass(String name, String pass) {
        this.num = name;
        this.pass = pass;
    }
}
