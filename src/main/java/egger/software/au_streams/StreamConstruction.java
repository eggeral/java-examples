package egger.software.au_streams;


import java.time.Instant;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamConstruction {
    public static void main(String[] args) {
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.accept(1);
        streamBuilder.add(2).add(3);

        streamBuilder.build().forEach(StreamConstruction::printElement);
        System.out.println();

        Stream.of(1,2,3).forEach(StreamConstruction::printElement);
        System.out.println();

        Stream.iterate(7, previous -> previous + 2).limit(5).forEach(StreamConstruction::printElement);
        System.out.println();

        Stream.generate(() -> 10).limit(5).forEach(StreamConstruction::printElement);
        System.out.println();

        Stream<Instant> timeStampStream = Stream.generate(() -> Instant.now());
        Iterator<Instant> timeStampIterator = timeStampStream.iterator();

        System.out.println(timeStampIterator.next());
        System.out.println(timeStampIterator.next());
    }

    private static void printElement(Integer element) {
        System.out.print(element + ", ");
    }
}
