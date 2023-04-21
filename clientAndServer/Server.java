package clientAndServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("hellow");
        //this syntactic sugar will make server auto closeable
        //so we don't have to manmually close it
        try (ServerSocket server = new ServerSocket(8080)){
            
            System.out.println("waiting for connection ...");
            
            //if we don't stop the server. It will not stop it automactally.
            //it will only be stopped if you restart your computer to reset this server
            
            //we can use while(true) to always listen to connected client
            //until we manually stop the server program
            while(true){
                Socket socket = server.accept();
                System.out.println("connected. IP address: "+ socket.getInetAddress().getHostAddress());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
