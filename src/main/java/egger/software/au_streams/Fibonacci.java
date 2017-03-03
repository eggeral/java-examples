package egger.software.au_streams;


import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        class Step {
            long previous;
            long value;

            Step(long previous, long value) {

                this.previous = previous;
                this.value = value;
            }
        }

        Stream<Step> fibs = Stream.iterate(
                new Step(1, 1),
                previousStep -> new Step(previousStep.value, previousStep.previous + previousStep.value)
        );

        fibs.mapToLong(step -> step.previous).limit(8).forEach(Fibonacci::printElement);
        System.out.println();
    }

    private static void printElement(Long element) {
        System.out.print(element + ", ");
    }
}
