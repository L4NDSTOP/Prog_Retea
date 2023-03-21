import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(4444);
    System.out.println("Server started on port 4444");

    while (true) {
      Socket clientSocket = serverSocket.accept();
      System.out.println("New client connected");

      Thread t = new Thread(new ClientHandler(clientSocket));
      t.start();


    }
  }
}

