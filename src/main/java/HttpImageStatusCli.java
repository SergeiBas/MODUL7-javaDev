import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HttpImageStatusCli {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpImageStatusCli.class);

    void askStatus() {
        BasicConfigurator.configure();
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean status = true;
            while (status) {
                LOGGER.info("Enter HTTP status code:");
                String s = scanner.nextLine();
                if(s.equals("stop")) status = false;
                if (!s.matches("\\d+")) {
                    LOGGER.info("Please enter a valid number!");
                    continue;
                }
                try {
                    downloader.downloadStatusImage(Integer.parseInt(s));
                    LOGGER.info("HTTP status found. Enter 'stop' if you want stop");
                } catch (Exception e) {
                    LOGGER.error(String.format("There is not image for HTTP status %s", s));
                }
            }
        }
    }
}

