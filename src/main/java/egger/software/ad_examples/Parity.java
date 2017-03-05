package egger.software.ad_examples;

public class Parity {

    public static void main(String args[]) {
        System.out.println(parity(0) + " (0b" + Integer.toBinaryString(0) + ") -- expected: false");
        System.out.println(parity(2) + " (0b" + Integer.toBinaryString(2) + ") -- expected: true");
        System.out.println(parity(3) + " (0b" + Integer.toBinaryString(3) + ") -- expected: false");
        System.out.println(parity(5) + " (0b" + Integer.toBinaryString(5) + ") -- expected: false");
        System.out.println(parity(16) + " (0b" + Integer.toBinaryString(16) + ") -- expected: true");
        System.out.println(parity(-1) + " (0b" + Integer.toBinaryString(-1) + ") -- expected: false");
    }

    // true if there is an odd number of 1-bits in number false else
    private static boolean parity(int bits) {
        boolean parity = false;
        // Shift every already tested bit out
        // Set all bits except the last one to zero and then XOR with our parity value
        for (int position = 0; position < Integer.SIZE; ++position) {
            // Shift every tested bit out
            int shifted = bits >> position;
            // set all bits except the last one to zero
            int testBit = shifted & 0b1;
            // XOR with parity value
            parity = parity ^ (testBit == 1);

        }
        return parity;
    }

}