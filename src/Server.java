import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
//        dataBase.readFile();
//        Restaurant restaurant = new Restaurant();
//        restaurant.name = "Restaurant1";
//        restaurant.score = 4.5;
//        restaurant.address = new Address("Tehran _ saadat Abad", 12.0, 13.0);
//        Food food = new Food();
//        food.name = "pizza";
//        food.price = 20000;
//        food.label = "FOOD";
//        food.details = "dad sdsa d asd asd asd";
//        food.counter = 1;
//        food.numberOfSales = 5;
//        restaurant.foods.add(food);
//        Comment comment = new Comment();
//        comment.text = "it was not bad";
//        comment.star = 3;
//        comment.answer = "a";
//        User u = new User();
//        u.name = "saeed";
//        comment.user = u;
//        restaurant.comments.add(comment);
//        restaurant.label = "PIZZA";
//        restaurant.phoneNumber = "09132546847";
//        dataBase.restaurants.add(restaurant);
//        System.out.println(restaurant);
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server created.");
        while (true) {
            Socket socket = ss.accept();
            System.out.println("a client connected.");
            System.out.println(dataBase.users);
            Thread clientThread = new Thread(new ClientHandler(socket, dataBase));
            clientThread.start();
        }

    }
}
