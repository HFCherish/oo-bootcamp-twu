import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author pzzheng
 * @date 11/21/17
 */
public class MommyTest1 {
    /**
     * @author pzzheng
     */
    @Test
    public void name() {
        Mommy mommy = new Mommy();
        assertThat(mommy.mommify("fd"), is("fdsfd"));
    }
}