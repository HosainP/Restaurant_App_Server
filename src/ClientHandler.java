import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;


public class ClientHandler implements Runnable {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    DataBase dataBase;

    ClientHandler(Socket socket, DataBase dataBase) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.dataBase = dataBase;
    }

    @Override
    public void run() {
        String command = "";
        Restaurant myRestaurant = new Restaurant();
        while (true) {
            try {
                command = dis.readLine();
                System.out.println("new command received: " + command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (command) {
                case "hLogin": {
                    String phoneNumber = "";
                    String password = "";
                    try {
                        phoneNumber = dis.readLine();
                        password = dis.readLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Login login = new Login(phoneNumber, password, dos);
                    System.out.println("login function is done.");
                    break;
                }
                case "hRegister": {
                    System.out.println("registration started.");
                    String phoneNumber = "";
                    String name = "";
                    String password = "";
                    String foodCategory = "";
                    try {
                        phoneNumber = dis.readLine();
                        name = dis.readLine();
                        password = dis.readLine();
                        foodCategory = dis.readLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Register register = new Register(phoneNumber, name, password, foodCategory);
                    System.out.println("Registration completed.");
                    break;
                }
                case "uLogin" : {
                    try {
                        String phoneNumber = dis.readLine();
                        String password = dis.readLine();
                        if (dataBase.findUser(phoneNumber, password) != null){
                            User user = dataBase.findUser(phoneNumber, password);
                            dos.writeBytes(user.getName() + ":::" + user.getPhoneNumber() + ":::" + user.getPassword() + ":::" + user.getGender() + ":::" + user.getBalance());
                        }
                        else {
                            dos.writeBytes("false");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "uSignUp": {
                    try {
                    String information = dis.readLine();
                    boolean response = dataBase.addUser(information);
                    if (response){
                        dos.writeBytes("true");
                    }
                    else {
                        dos.writeBytes("false");
                    }
                }
             catch (IOException e) {
                e.printStackTrace();
            }
                    break;
                }
                case "ugetRestaurantsList" : {
                    try {
                        System.out.println(DataBase.restaurants.size());
                        String information = "";
                        int number = DataBase.restaurants.size();
                        information+=number;
                        information+="#";
                        for (int i = 0; i < number; i++) {
                            Restaurant rest = DataBase.restaurants.get(i);
                            information+=rest.name+":::"+rest.score+":::"+rest.address.getAddressName()+":::"+rest.address.getLatitude()+":::"+rest.address.getLongitude()+":::"+rest.label;
                            information+="-";
                            int numberOfFood = rest.foods.size();
                            information+=numberOfFood;
                            information+="-";
                            for (int j = 0; j < numberOfFood; j++) {
                                Food food = rest.foods.get(j);
                               information+=food.name + ":::" + food.details + ":::"+food.price+":::"+food.label+":::"+food.counter+":::"+food.numberOfSales+":::";
                                   information+="@";
                            }
                            information+="-";
                            int numberOfComment = rest.comments.size();
                            information+=numberOfComment+"-";
                            for (int j = 0; j < numberOfComment; j++) {
                                Comment comment = rest.comments.get(j);
                                information+=comment.text + ":::" + comment.answer + ":::" + comment.star + ":::" + comment.user.getName();
                                information+="@";
                            }
                            information+="#";
                        }
                        dos.writeBytes(information);
                        System.out.println(information);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                }
                case "uAddToFavorite" : {
                    try {
                        String message = dis.readLine();
                        String userPhoneNumber = message.split(":::")[0];
                        String restaurantPhoneNumber = message.split(":::")[1];
                        dataBase.findUser(userPhoneNumber).favoriteRestaurant.add(dataBase.findRestaurant(restaurantPhoneNumber));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "removeFromFavorite" : {
                    try {
                        String message = dis.readLine();
                        String userPhoneNumber = message.split(":::")[0];
                        String restaurantPhoneNumber = message.split(":::")[1];
                        dataBase.findUser(userPhoneNumber).favoriteRestaurant.remove(dataBase.findRestaurant(restaurantPhoneNumber));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

}

