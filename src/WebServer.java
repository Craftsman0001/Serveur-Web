import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private void readRequest(Socket socket){ 
        try {
            BufferedReader input;
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = "";
            while((response = input.readLine()).isEmpty() == false){
                System.out.println(response);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    private void sendResponse(Socket socket){
        try{
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.write("HTTP/1.0 200 OK\n");
            output.flush();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
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
