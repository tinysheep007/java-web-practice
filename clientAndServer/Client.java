package clientAndServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        //we can put 127.0.0.1 in first parameter too
        
        try (Socket socket = new Socket("localhost", 8080);){
            
            System.out.println("connected");

        } catch(IOException e){
            System.out.println("conection failed");
            e.printStackTrace();
        }
        
        
    }
}