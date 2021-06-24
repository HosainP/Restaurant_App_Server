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
                }
            }
        }
    }

}

