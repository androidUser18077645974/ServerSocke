
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket  =  new ServerSocket(30000);
        Socket socket = serverSocket.accept();

        InputStream reader = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(reader));

        System.out.println(br.readLine());

        reader.close();
        socket.close();
    }
}
