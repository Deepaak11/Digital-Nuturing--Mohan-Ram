import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 1234);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("connected to server.");
            String messageFromServer;
            while (true) {
                System.out.print("you: ");
                String userMessage = console.readLine();
                if (userMessage == null || userMessage.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.println(userMessage);
                messageFromServer = reader.readLine();
                if (messageFromServer == null) break;
                System.out.println("server: " + messageFromServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
