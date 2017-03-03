package egger.software.ah_generics;

public class ConstraintBox<TContent extends Number> {
    private TContent content;

    public ConstraintBox(TContent content) {
        this.content = content;
    }

    public TContent getContent() {
        return content;
    }

    public void setContent(TContent content) {
        this.content = content;
    }
}
