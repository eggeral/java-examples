package egger.software.ak_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class AverageCalculatorLambda {
    static class AverageCalculator {

        private Supplier<List<Double>> valueSupplier;

        AverageCalculator(Supplier<List<Double>> valueSupplier) {
            this.valueSupplier = valueSupplier;
        }

        double calculateAverage() {
            List<Double> values = valueSupplier.get();
            double sum =0;
            for (Double value : values) {
                sum = sum + value;
            }
            return sum / values.size();
        }

    }

    public static void main(String[] args) {
        AverageCalculator averageCalculator = new AverageCalculator(() -> {
            //Assume we open the file and parse the values here!
            return Arrays.asList(1.0,2.0,3.0);
        });
        System.out.println(averageCalculator.calculateAverage());

        averageCalculator = new AverageCalculator(() -> Arrays.asList(10.0,20.0,30.0));
        System.out.println(averageCalculator.calculateAverage());
    }

}
