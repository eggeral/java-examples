package egger.software.ae_classes;

public class PrintCommand implements Command {

    @Override
    public void execute() {
        System.out.println("print");

    }
}
