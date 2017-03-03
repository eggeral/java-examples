package egger.software.aq_annotations;

import java.lang.reflect.Method;

@MarkIt(tag = "type tag")
public class AnnotationUsage {
    @MarkIt(tag = "field tag") public String aField;

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        //Type annotation
        MarkIt typeAnnotation = AnnotationUsage.class.getAnnotation(MarkIt.class);
        System.out.println("Type annotated with: " + typeAnnotation.tag());

        //Field annotation
        MarkIt fieldAnnotation = AnnotationUsage.class.getField("aField").getAnnotation(MarkIt.class);
        System.out.println("Field annotated with: " + fieldAnnotation.tag());

        //Method annotation
        Method showTagsMethod = AnnotationUsage.class.getMethod("showTags", String.class);
        MarkIt methodAnnotation = showTagsMethod.getAnnotation(MarkIt.class);
        System.out.println("Method showTags annotated with: " + methodAnnotation.tag());

        //Method parameter annotation
        MarkIt paramAnnotation = showTagsMethod.getParameters()[0].getAnnotation(MarkIt.class);
        System.out.println("Parameter hello annotated with: " + paramAnnotation.tag());

        //Type usage annotation can only be accessed by the compiler (see http://types.cs.washington.edu/checker-framework/)
        @MarkIt(tag = "local var tag") String msg = "hello world";

    }

    @MarkIt(tag = "method tag")
    public void showTags(@MarkIt(tag = "param tag") String hello) throws NoSuchMethodException {
    }
}
