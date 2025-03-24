public class WebServerApplication {
    public static void main(String[] args) throws Exception {
        WebServer webServer = new WebServer();
        webServer.run(80);
    }
}
