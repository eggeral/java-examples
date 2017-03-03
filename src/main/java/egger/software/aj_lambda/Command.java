package egger.software.aj_lambda;

@FunctionalInterface //optional. not needed by the compiler
public interface Command {
    void execute();
}
