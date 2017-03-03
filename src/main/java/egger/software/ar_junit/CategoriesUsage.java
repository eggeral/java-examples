package egger.software.ar_junit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoriesUsage {
    @Test
    @Category(LongRunningTestSuite.LongRunningTest.class)
    public void aLongRunningTest() {
        System.out.println("Long running test");
    }

    @Test
    public void normalTest() {
        System.out.println("Normal test");
    }
}
