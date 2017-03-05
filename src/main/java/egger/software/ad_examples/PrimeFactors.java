package egger.software.ad_examples;

public class PrimeFactors {

    public static void main(String[] args) {

        System.out.println(primeFactors(0) + " -- expected: This value is not valid!");
        System.out.println(primeFactors(-1) + " -- expected: This value is not valid!");
        System.out.println(primeFactors(1) + " -- expected: This value is not valid!");
        System.out.println(primeFactors(2) + " -- expected: 2");
        System.out.println(primeFactors(5) + " -- expected: 5");
        System.out.println(primeFactors(10) + " -- expected: 2 * 5");
        System.out.println(primeFactors(256) + " -- expected: 2^8");
        System.out.println(primeFactors(6534) + " -- expected: 2 * 3^3 * 11^2");
        System.out.println(primeFactors(13332) + " -- expected: 2^2 * 3 * 11 * 101");

    }

    private static String primeFactors(long number) {
        boolean first = true;
        String result = "";

        if (number <= 1) {
            return "This value is not valid!";
        }

        for (long idx = 2; idx <= number; idx++) {
            long count = 0;
            while (number % idx == 0) {
                count++;
                number /= idx;
            }
            if (count > 0) {
                if (!first)
                    result += " * ";
                else
                    first = false;

                if (count == 1)
                    result += ("" + idx);
                else
                    result += (idx + "^" + count);

            }
        }

        return result;
    }
}
