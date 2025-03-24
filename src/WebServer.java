import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
private void readRequest(Socket socket){
    
}
private void sendResponse(Socket socket){

}
public WebServer(){}
public void run(int portNumber){
    try{
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while(true){
            Socket clienSocket = serverSocket.accept();
            //traitement de la requete client
            readRequest(clienSocket);
            sendResponse(clienSocket);
            clienSocket.close();
        }
    }catch(Exception e){
        System.err.println(e.getMessage());
    }
    

}
}
