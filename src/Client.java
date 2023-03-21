import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 4444);
    System.out.println("Connected to server on port 4444");

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    while (true) {
      System.out.print("Enter message: ");
      String message = keyboard.readLine();

      out.println(message);

      String response = in.readLine();
      System.out.println("Server response: " + response);
    }
  }
}