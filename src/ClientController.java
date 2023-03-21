import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientController implements Runnable {

    private Socket clientSocket;

    public ClientController(Socket socket) {
      this.clientSocket = socket;
    }

    public void run() {
      try {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        while (true) {
          String message = in.readLine();

          if (message == null) {
            break;
          }

          System.out.println("Received message: " + message);

          out.println(message);
        }
      } catch (IOException e) {
        System.out.println("Error handling client connection: " + e.getMessage());
      } finally {
        try {
          clientSocket.close();
        } catch (IOException e) {
          System.out.println("Error closing client connection: " + e.getMessage());
        }
      }
    }
  }

