package egger.software.ar_junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.*;

public class Hamcrest {

    @Test
    public void showSomeHamcrestMatchers() {
        assertThat("test", is("test"));
        assertThat("test", is(anything()));
        assertThat(null, is(nullValue()));
        assertThat("test", is(notNullValue()));
        assertThat("test", is(not("hello")));
        assertThat("test", endsWith("st"));

        Object o1 = new Object();
        Object o2 = o1;
        assertThat(o2, is(sameInstance(o2)));

        assertThat("test", is(instanceOf(String.class)));

        assertThat(2, is(allOf(lessThan(3), greaterThan(1))));
        assertThat(2, is(anyOf(lessThan(5), greaterThan(1))));

        class Book {
            public String getTitle() { return "Hobbit"; }
        }
        assertThat(new Book(), hasProperty("title"));

        assertThat(new String[]{"1", "2", "3"}, is(arrayContaining("1", "2", "3")));
        assertThat(Arrays.asList("1", "2", "3"), hasItems("3", "2"));
        assertThat(Arrays.asList("1", "2", "3"), contains("1", "2", "3"));

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"test");
        assertThat(map, hasKey(1));
        assertThat(map, hasValue("test"));
        assertThat(map, not(hasValue("hello")));

        assertThat(1.01, is(closeTo(1.0, 0.02)));

    }

    @Test
    public void meaningfulFailureMessages() {
        assertThat(2, is(allOf(lessThan(3), greaterThan(2))));
    }
}
