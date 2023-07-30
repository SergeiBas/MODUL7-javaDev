import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpStatusImageDownloader.class);

    void downloadStatusImage(int code) {
        try {
            URL url = new URL(new HttpStatusChecker().getStatusImage(code));
            InputStream inputStream = url.openStream();
            new File("src/main/images").mkdir();
            OutputStream outputStream = new FileOutputStream(String.format("src/main/images/status-%s.jpg", code));
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (IOException ee) {
            throw new RuntimeException();
        }
    }
}