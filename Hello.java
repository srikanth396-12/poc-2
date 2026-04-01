import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
 
public class Hello {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
 
        server.createContext("/", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello from Jenkins Docker Sonar POC";
                byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
 
                exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
                exchange.sendResponseHeaders(200, bytes.length);
 
                OutputStream os = exchange.getResponseBody();
                os.write(bytes);
                os.close();
            }
        });
 
        server.start();
        System.out.println("Server started on port 8080");
    }
}
