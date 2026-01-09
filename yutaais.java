import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class YutaAIServer{
  public static void main(String[] args) throws Exception{
    HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
    server.createContext("/ask", (exchange)->{
        InputStream is = exchange.getRequestBody();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine())!=null) sb.append(line);
        String response = "{\"answer\":\"こんにちは！YutaAIです\"}";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    });
    server.start();
  }
}
