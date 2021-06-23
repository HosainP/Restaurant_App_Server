import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class ClientHandler implements Runnable {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());

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
            }
        }
    }

}

