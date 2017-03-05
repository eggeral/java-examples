package egger.software.ak_examples;

import java.util.Arrays;
import java.util.List;

public class AverageCalculatorAbstract {
    static abstract class AbstractAverageCalculator {

        double calculateAverage() {
            List<Double> values = getValues();
            double sum =0;
            for (Double value : values) {
                sum = sum + value;
            }
            return sum / values.size();
        }

        protected abstract List<Double> getValues();

    }

    static class FileAverageCalculator extends AbstractAverageCalculator {

        private String fileName;

        FileAverageCalculator(String fileName) {
            this.fileName = fileName;
        }

        @Override
        protected List<Double> getValues() {
            //Assume we open the file and parse the values here!
            return Arrays.asList(1.0,2.0,3.0);
        }
    }

    static class DummyAverageCalculator extends AbstractAverageCalculator {

        @Override
        protected List<Double> getValues() {
            return Arrays.asList(10.0,20.0,30.0);
        }
    }

    public static void main(String[] args) {
        AbstractAverageCalculator averageCalculator = new FileAverageCalculator("test.csv");
        System.out.println(averageCalculator.calculateAverage());

        averageCalculator = new DummyAverageCalculator();
        System.out.println(averageCalculator.calculateAverage());
    }

}
