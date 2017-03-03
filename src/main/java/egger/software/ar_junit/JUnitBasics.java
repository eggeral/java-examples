package egger.software.ar_junit;


import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JUnitBasics {

    @BeforeClass
    public static void alwaysExectutedBeforeAllTestsInAClass() {
        System.out.println("before class");
    }

    @Before //can be inherited!
    public void alwaysExecutedBeforeATest() {
        System.out.println("before");
    }

    @After
    public void alwaysExecutedAfterATest() {
        System.out.println("after");
    }

    @AfterClass
    public static void alwaysExectutedAfterAllTestsInAClass() {
        System.out.println("after class");
    }

    @Test //mark a method a test
    public void aStringCanBeAskedForACharAtAGivenIndex() {
        //given
        String target = new String("0123456");

        //when
        char result = target.charAt(3);

        //then
        assertThat(result, is('3'));
    }

    @Test
    @Ignore
    public void ignoredTest() {
        assertThat(true, is(false));
    }


    @Test
    public void anotherTest() {
        assertThat(true, is(true));
    }

    @Test
    public void showThatAfterAndAfterClassAreAlwaysCalled() {
        throw new IllegalStateException("test before and after");
    }


}
