import java.io.*;
import java.net.Socket;

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

    ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        String command = "";
        Restaurant theRestaurant = new Restaurant();
        String restaurantInfo = "";
        while (true) {

            // overwriting the files here.

//            for (Restaurant r : dataBase.restaurants) {
//                String address = Constants.hDataBaseAddress + "\\Restaurants\\" + r.name + "-" + r.phoneNumber;
//                RewriteRestaurant rewriteRestaurant = new RewriteRestaurant(r, address);
//                rewriteRestaurant.Rewrite();
//            }

            //

            try {
                command = dis.readLine();
                System.out.println("new command received: " + command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (command == null) {
                command = "do nothing";
            }
            switch (command) {
                case "do nothing": {
                    break;
                }
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
                    theRestaurant = login.getRestaurant();
                    System.out.println("login function is done.");

                    // now it's time to send information to the app to make the look.

                    theRestaurant = login.getRestaurant(); //this restaurant info should be sent to the app.
                    String info = ":::::" + theRestaurant.name + ":::::" + theRestaurant.phoneNumber + ":::::" + theRestaurant.password + ":::::";
                    info = info + theRestaurant.score + ":::::" + theRestaurant.label + ":::::" + theRestaurant.address + ":::::";
                    info = info + theRestaurant.discountCode + ":::::";
                    for (Food f : theRestaurant.foods) {
                        info = info + f.name + ":::" + f.details + ":::" + f.label + ":::" + f.price + ":::" + f.numberOfSales + ":::" + f.counter + ":::" + f.isAvailable;
                        info = info + "::::";
                    }
                    info = info + ":";
                    for (Comment c : theRestaurant.comments) {
                        info = info + c.text + ":::" + c.answer + ":::" + c.userName + ":::" + c.star + ":::" + c.checked;
                        info = info + "::::";
                    }
                    info = info + ":";
                    for (Order o : theRestaurant.orders) {
                        info = info + o.year + ":::" + o.month + ":::" + o.day + ":::" + o.time + ":::" + o.userName + ":::" + o.getTrackingNumber() + ":::";
                        info = info + o.sum + ":::";
                        for (Food f : o.orders) {
                            info = info + f.name + ":" + f.details + ":" + f.label + ":" + f.price + ":" + f.numberOfSales + ":" + f.counter + ":" + f.isAvailable;
                            info = info + "::";
                        }
                        info = info + "::";
                    }
                    info = info + ":";

                    //now the string to send to the app is ready as info.

                    if (login.isAccepted) {
                        try {
                            dos.writeBytes("true" + info);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            dos.writeBytes("false");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

//                    try {
//                        dos.writeBytes(theRestaurant.name);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

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
                    try {
                        Register register = new Register(phoneNumber, name, password, foodCategory);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Registration completed.");
                    break;
                }
                case "uLogin": {
                    try {
                        String phoneNumber = dis.readLine();
                        String password = dis.readLine();
                        if (dataBase.findUser(phoneNumber, password) != null) {
                            User user = dataBase.findUser(phoneNumber, password);
                            dos.writeBytes(user.getName() + ":::" + user.getPhoneNumber() + ":::" + user.getPassword() + ":::" + user.getGender() + ":::" + user.getBalance());
                        } else {
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
                        if (response) {
                            dos.writeBytes("true");
                        } else {
                            dos.writeBytes("false");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ugetRestaurantsList": {
                    try {
                        System.out.println(dataBase.restaurants.size());
                        String information = "";
                        int number = dataBase.restaurants.size();
                        information += number;
                        information += "#";
                        for (int i = 0; i < number; i++) {
                            Restaurant rest = dataBase.restaurants.get(i);
                            information += rest.name + ":::" + rest.score + ":::" + rest.address.getAddressName() + ":::" + rest.address.getLatitude() + ":::" + rest.address.getLongitude() + ":::" + rest.label + ":::" + rest.phoneNumber;
                            information += "-";
                            int numberOfFood = rest.foods.size();
                            information += numberOfFood;
                            information += "-";
                            for (int j = 0; j < numberOfFood; j++) {
                                Food food = rest.foods.get(j);
                                information += food.name + ":::" + food.details + ":::" + food.price + ":::" + food.label + ":::" + food.counter + ":::" + food.numberOfSales + ":::";
                                information += "@";
                            }
                            information += "-";
                            int numberOfComment = rest.comments.size();
                            information += numberOfComment + "-";
                            for (int j = 0; j < numberOfComment; j++) {
                                Comment comment = rest.comments.get(j);
                                information += comment.text + ":::" + comment.answer + ":::" + comment.star + ":::" + comment.user.getName();
                                information += "@";
                            }
                            information += "#";
                        }
                        dos.writeBytes(information);
                        System.out.println(information);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }
                case "uAddToFavorite": {
                    try {
                        String message = dis.readLine();
                        String userPhoneNumber = message.split(":::")[0];
                        String restaurantPhoneNumber = message.split(":::")[1];
                        dataBase.findUser(userPhoneNumber).favoriteRestaurant.add(dataBase.findRestaurant(restaurantPhoneNumber));
                        System.out.println("restaurant " + dataBase.findRestaurant(restaurantPhoneNumber).name + " added to favorite List user " + dataBase.findUser(userPhoneNumber).name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "uRemoveFromFavorite": {
                    try {
                        String message = dis.readLine();
                        String userPhoneNumber = message.split(":::")[0];
                        String restaurantPhoneNumber = message.split(":::")[1];
                        dataBase.findUser(userPhoneNumber).favoriteRestaurant.remove(dataBase.findRestaurant(restaurantPhoneNumber));
                        System.out.println("restaurant " + dataBase.findRestaurant(restaurantPhoneNumber).name + " removed from favorite List user " + dataBase.findUser(userPhoneNumber).name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "addComment": {
                    try {
                        String message = dis.readLine();
                        String userPhoneNumber = message.split(":::")[0];
                        String restaurantPhoneNumber = message.split(":::")[1];
                        Comment comment = new Comment(message.split(":::")[2], Integer.parseInt(message.split(":::")[3]), dataBase.findUser(userPhoneNumber), message.split(":::")[4]);
                        dataBase.findRestaurant(restaurantPhoneNumber).comments.add(comment);
                        dataBase.findUser(userPhoneNumber).comments.add(comment);
                        System.out.println("comment added to " + dataBase.findRestaurant(restaurantPhoneNumber).name + " and " + dataBase.findUser(userPhoneNumber).name + " :)");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case "changeBalance": {
                    try {
                        String message = dis.readLine();
                        String userPhoneNumber = message.split(":::")[0];
                        int newBalance = Integer.parseInt(message.split(":::")[1]);
                        dataBase.findUser(userPhoneNumber).balance = newBalance;
                        System.out.println("user " + dataBase.findUser(userPhoneNumber).name + " increase his balance to " + newBalance);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                dataBase.writeFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

