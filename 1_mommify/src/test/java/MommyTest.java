import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author pzzheng
 * @date 11/16/17
 */
public class MommyTest {
    /**
     * @author pzzheng
     * @date ${DATE}
     */
    @Test
    public void should_replace_vowel() {
        Mommy mommy = new Mommy();
        String result = mommy.mommify("a");
        assertThat(result, is("mommy"));
    }
}