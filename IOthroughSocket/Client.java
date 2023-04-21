package IOthroughSocket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

//Remeber to run the server before the client or else error
public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket();
        Scanner scanner = new Scanner(System.in)){
            //we can create socket and connect later
            socket.connect(new InetSocketAddress("localhost", 8080));
            System.out.println("connected");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(scanner.nextLine()+"\n");
            writer.flush();

            //close the socket, since no more output
            //close one directional stream of socket
            socket.shutdownOutput();

            System.out.println("data transferred. Wait for Server to confirm ...");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("recevied server confirmation: " + reader.readLine());
            

        } catch(IOException e){
         
            e.printStackTrace();
        }
    }
}
