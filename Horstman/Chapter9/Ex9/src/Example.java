import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by Acer on 05.04.2017.
 */
public class Example {

    static void readWebPage(String login, String password) {
        String dataToEncoding = login + ":" + password;
        String coded = Base64.getEncoder().encodeToString(dataToEncoding.getBytes(StandardCharsets.UTF_8));
        try {
            URL url = new URL("http://localhost/java/");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("Accept-Charset", "UTF-8, ISO-8859-2");
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Basic " + coded);
            connection.getDoOutput();
            InputStream content = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            String line;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String login = "wipek";
        String password = "12345";
        readWebPage(login, password);
    }
}
