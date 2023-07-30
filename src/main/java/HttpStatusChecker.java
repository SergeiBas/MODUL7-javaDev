import java.io.IOException;
import java.net.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        try {
            URL url = new URL(String.format("https://http.cat/%s.jpg", code));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 404) {
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return String.format("https://http.cat/%s.jpg", code);
    }
}