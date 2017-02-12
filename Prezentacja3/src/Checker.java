import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

/**
 * Created by Krzysztof Adamczyk on 11.02.2017.
 */
public class Checker {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\w{1,}[@]\\w{1,}[.]\\w{1,}");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an email");
        String s = new String();
        try{
            s = rd.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }

        Matcher m = p.matcher(s);
        System.out.println("Pattern (" + p + " matches " + s + ": " + m.matches());
    }
}
