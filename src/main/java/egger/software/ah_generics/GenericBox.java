package egger.software.ah_generics;

public class GenericBox<TContent> {
    private TContent content;

    public GenericBox(TContent content) {
        this.content = content;
    }

    public TContent getContent() {
        return content;
    }

    public void setContent(TContent content) {
        this.content = content;
    }
}
