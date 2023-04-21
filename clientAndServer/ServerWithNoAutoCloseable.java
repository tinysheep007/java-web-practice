package clientAndServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWithNoAutoCloseable{
    public static void main(String[] args) {
        System.out.println("hellow");

        try{
            ServerSocket server = new ServerSocket(8080);
            System.out.println("waiting for connection ...");
            Socket socket = server.accept();
            System.out.println("connected. IP address: "+ socket.getInetAddress().getHostAddress());
            //if we don't stop the server. It will not stop it automactally.
            //it will only be stopped if you restart your computer to reset this server
            
            server.close();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}