package IOthroughSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            
            System.out.println("waiting for connection ...");
            
            Socket socket = server.accept();
            //if input from client to server deteced under
            //3 seconds, then return error
            socket.setSoTimeout(3000);
            System.out.println("connected. IP address: "+ socket.getInetAddress().getHostAddress());
            System.out.println("reading client data: ");

            BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            System.out.println(reader.readLine());

            // System.out.println("client data read");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("data received by server");
            writer.flush();

            socket.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
