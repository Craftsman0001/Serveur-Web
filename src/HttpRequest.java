import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {
    private String method;
    private String url;
    private void readClientRequest(Socket socket){
        try {
        BufferedReader input;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = "";
        while((response = input.readLine()).isEmpty() == false);
        String[] words = response.split(" ");
        this.method = words[0];
        this.url = words[1];
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public HttpRequest(Socket socket){
        readClientRequest(socket);
    }
    public String getMethod(){
        return this.method;
    }
    public String getUrl(){
        return this.url;
    }
}
