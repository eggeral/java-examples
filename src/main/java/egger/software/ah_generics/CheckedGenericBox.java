package egger.software.ah_generics;

import java.lang.reflect.ParameterizedType;

public class CheckedGenericBox<TContent> {
    private TContent content;
    private Class genericType;

    public CheckedGenericBox(TContent content) {
        genericType = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        setContent(content);
    }

    public TContent getContent() {
        return content;
    }

    public void setContent(TContent content) {
        // if (content instanceof TContent) does not work! Type info not available
        if (content.getClass() != genericType) {
            throw new IllegalArgumentException(content.getClass() + " is not of type " + genericType);
        }
        this.content = content;

    }
}
