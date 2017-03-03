package egger.software.ah_generics;

public class CoContra {
    public static void main(String[] args) {
        GenericBox<Integer> intBox = new GenericBox<>(10);
        //GenericBox<Number> numberBox = intBox; does not compile
        GenericBox<? extends Number> numberBox = intBox; //co variant

        //numberBox.setContent(10.0); //does not work
        GenericBox<? super Number> numberBoxContra = new GenericBox<>(10);
        numberBoxContra.setContent(10.0);
    }
}
