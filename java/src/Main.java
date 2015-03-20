import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaoqunqi on 15-2-10.
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pattern p = Pattern.compile("^((\\+86)|(86))?(13)\\d$");
        Matcher m = p.matcher("+8615353098266");
        System.out.println(m.matches());
        System.out.println(Integer.MAX_VALUE);
    }

}
