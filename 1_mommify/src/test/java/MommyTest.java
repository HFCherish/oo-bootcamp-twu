import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author pzzheng
 * @date 11/16/17
 */
public class MommyTest {

    private Mommy mommy;

    @Before
    public void setUp() {
        mommy = new Mommy();
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_replace_vowel() {
        assertThat(mommy.mommify("a"), is("mommy"));
        assertThat(mommy.mommify("e"), is("mommy"));
        assertThat(mommy.mommify("o"), is("mommy"));
    }
    /**
     * @author pzzheng
     */
    @Test
    public void should_not_replace_other_character() {
        assertThat(mommy.mommify(""), is(""));
        assertThat(mommy.mommify("b"), is("b"));
        assertThat(mommy.mommify(" "), is(" "));
        assertThat(mommy.mommify(null), is(nullValue()));
    }

}