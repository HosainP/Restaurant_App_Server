import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
        dataBase.readFile();
        Restaurant restaurant = new Restaurant();
        restaurant.name = "res1";
        restaurant.score = 4.5;
        restaurant.address = new Address("fsdfdsfsd", 12.0,13.0);
        Food food = new Food();
        food.name = "fsdfdsf";
        food.price = 12;
        food.label = "PIZZA";
        food.details = "Fdsfdsfdsfsdf";
        food.counter = 2;
        food.numberOfSales = 5;
        restaurant.foods.add(food);
        Comment comment = new Comment();
        comment.text = "fdsfdsfsd";
        comment.star = 5;
        comment.answer = "";
        User u = new User();
        u.name = "saeed";
        comment.user = u;
        restaurant.comments.add(comment);
        DataBase.restaurants.add(restaurant);
        System.out.println(restaurant);
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server created.");
        while(true){
            Socket socket = ss.accept();
            System.out.println("a client connected.");
            System.out.println(dataBase.users);
            Thread clientThread = new Thread(new ClientHandler(socket, dataBase));
            clientThread.start();
        }

    }
}
