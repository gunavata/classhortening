import java.util.Arrays;
import java.util.List;

/**
 * @author Tan Oliver
 */
public class Main {

    private static final ShortService service = new ShortService();

    public static void main(String[] args) {
        List<String> classNameList = Arrays.asList(args);

        for (String className: classNameList) {
            String result = service.shortenClassName(className, 10);
            System.out.println(result);
        }

    }


}
