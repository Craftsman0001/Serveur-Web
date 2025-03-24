import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {
    private BufferedWriter output;
    public HttpResponse(Socket socket){
        try{
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.output = output;
    }catch(Exception e){
        System.err.println(e.getMessage());
    }
    }
    public void ok(String message){
        try{
            this.output.write("HTTP/1.0 200 " + message + "\n");
            output.flush();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void notFound(String message){
        try{
            this.output.write("HTTP/1.0 404 " + message + "\n");
            output.flush();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
