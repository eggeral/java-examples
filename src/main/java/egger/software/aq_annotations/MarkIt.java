package egger.software.aq_annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) //Annotation is available at runtime
@Inherited //Subclasses inherit the annotation
@Target({ElementType.TYPE, ElementType.TYPE_USE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
public @interface MarkIt {
    String tag();
}
