package egger.software.ah_generics;

public class Box {
    private Object content;

    public Box(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
