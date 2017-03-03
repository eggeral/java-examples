package egger.software.ar_junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

@RunWith(value = TestRunners.MyRunner.class)
public class TestRunners {

    public static class MyRunner extends BlockJUnit4ClassRunner {

        public MyRunner(Class<?> klass) throws InitializationError {
            super(klass);
        }

        @Override
        protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
            System.out.println("About to run: " + method.getName());
            super.runChild(method, notifier);
            System.out.println("finished to run: " + method.getName());
        }

    }

    @Test
    public void dummyTest() {
        assertThat(true, is(true));
    }
}
