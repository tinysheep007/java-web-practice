package transferFilesThroughServer;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            //wait for client to connect
            Socket socket = server.accept();

            //create input stream to get from client side
            InputStream stream = socket.getInputStream();
            //we have to make sure our folder already exist
            //it won't create for us
            FileOutputStream fileOutputStream = new FileOutputStream("./transferFilesThroughServer/net/data.txt");
            int i;
            //same as Java SE way of passing files over
            byte[] bytes = new byte[1024];
            while((i = stream.read(bytes)) != -1){
                fileOutputStream.write(bytes, 0 ,i);
            }
            //refresh make sure everything is received
            fileOutputStream.flush();
            fileOutputStream.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
