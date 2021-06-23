import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("server created.");
        while(true){
            Socket socket = ss.accept();
            System.out.println("a client connected.");
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }

    }
}
