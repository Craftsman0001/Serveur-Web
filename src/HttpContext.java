import java.net.Socket;
import java.net.ServerSocket;

public class HttpContext {
    private Socket socket;
    private HttpRequest request;
    private HttpResponse response;
    public HttpContext(Socket socket){
        this.socket = socket;
        this.request = new HttpRequest(this.socket);
        this.response = new HttpResponse(this.socket);
    }
    public HttpRequest getRequest(){
        return this.request;
    }
    public HttpResponse getResponse(){
        return this.response;
    }
    public void close(){
        try{
            this.socket.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
