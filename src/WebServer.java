import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public WebServer(){}
    public void run(int portNumber){
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true){
                Socket clienSocket = serverSocket.accept();
                //traitement de la requete client
                RequestProcessor requestProcessor = new RequestProcessor(clienSocket);
                clienSocket.close();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
