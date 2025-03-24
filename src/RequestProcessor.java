import java.net.Socket;

public class RequestProcessor {
    private HttpContext context;
    private void process(){
        if(this.context.getRequest().getUrl().equals("/")){
            this.context.getResponse().ok("bon URL");
        }
        else{
            this.context.getResponse().ok("mauvais URL");
        }
    }
    public void RequestProcessor(Socket socket){
        this.context = new HttpContext(socket);
    }
}
