package egger.software.aq_annotations;

import java.util.ArrayList;
import java.util.List;

public class PredefinedAnnotations implements Runnable {
    public void suppressWarningOfUnsafeGenericCast() {
        @SuppressWarnings(value = "unchecked")
        List<String> list = (List<String>) new ArrayList();
    }

    @Override
    public void run() {}

    //@Override //prevents the typo
    public void runn() {}

    @Deprecated
    public void oldMethod() {}

}
