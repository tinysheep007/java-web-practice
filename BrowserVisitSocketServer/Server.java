package BrowserVisitSocketServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8080)){
            System.out.println("waiting for client connection ...");
            Socket socket = server.accept();
            System.out.println("client connected. IP: "+socket.getInetAddress().getHostAddress());
            InputStream in = socket.getInputStream();
            System.out.println("receiving client data:");
            while(true){
                int i = in.read();
                if(i == -1) break;
                System.out.print((char) i);
            }
        
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
