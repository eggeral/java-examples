package egger.software.ar_junit;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(LongRunningTestSuite.LongRunningTest.class)
@Suite.SuiteClasses({CategoriesUsage.class, JUnitBasics.class})
public class LongRunningTestSuite {
    public interface LongRunningTest {}
}
