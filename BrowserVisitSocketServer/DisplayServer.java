package BrowserVisitSocketServer;

import java.io.IOError;
import java.io.IOException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class DisplayServer {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8080)){
            System.out.println("waiting for connection ...");
            Socket socket = server.accept();
            System.out.println("client connected. IP: "+socket.getInetAddress().getHostAddress());
            // InputStream in = socket.getInputStream();
            System.out.println("reciving client data: ");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("HTTP/1.1 200 Accepted\r\n");
            writer.write("\r\n");
            writer.write("<h1>hello world</h1><div>This is the content</div>");
            writer.flush();
            socket.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
