package egger.software.ar_junit;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class TestingForExceptions {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = NullPointerException.class)
    public void expectedException() {
        throw new NullPointerException("expected exception");
    }

    @Test
    public void handleWithTryCatch() {
        try {
            new ArrayList<String>().get(0);
        } catch(IndexOutOfBoundsException ex) {
            assertThat(ex.getMessage(), containsString("Index: 0"));
        }
    }

    @Test
    public void handleWithRule() {
        List<String> list = new ArrayList<>();
        //list.get(0); //lets the test fail

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0);
    }
}
