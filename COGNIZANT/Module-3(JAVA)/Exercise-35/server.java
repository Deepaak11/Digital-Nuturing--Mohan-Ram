import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("server started");
        Socket socket = serverSocket.accept();
        System.out.println("client connected");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String messageFromClient;
        while ((messageFromClient = reader.readLine()) != null) {
            System.out.println("client: " + messageFromClient);
            System.out.print("you: ");
            String response = console.readLine();
            writer.println(response);
        }
        socket.close();
        serverSocket.close();
    }
}
