import java.util.Arrays;
import java.util.List;

/**
 * @author pzzheng
 * @date 11/16/17
 */
public class Mommy {

    public static final List<String> VOVELS = Arrays.asList("a", "e", "i", "o", "u");

    public String mommify(String a) {

        if (VOVELS.contains(a)) {
            return "mommy";
        }

        return a;
    }

}
