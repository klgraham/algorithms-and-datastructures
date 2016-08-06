package org.klgraham;

/**
 * Given an integer, convert it to a binary representation
 */
public class OneHotEncoder {

    private final int dim;
    private final int max;

    public OneHotEncoder(int dim) {
        this.dim = dim;
        this.max = (int)Math.pow(2, dim) - 1;
    }

    public static void main(String[] args) throws ImproperInputException {
        OneHotEncoder encoder = new OneHotEncoder(8);

        for (int i = 0; i < 10; i++) {
            printArray(encoder.encode(i));
        }
    }

    public int[] encode(final int n) throws ImproperInputException {
        if (n > max) {
            int smallestDimension = (int)(Math.log(n + 1) / Math.log(2));
            throw new ImproperInputException(n + " is too large for encoding dimension. Minimum dimension must be " + smallestDimension);
        }

        int[] encoding = new int[dim];
        String s = Integer.toString(n, 2);

        for (int i = 0; i < s.length(); i++) {
            encoding[i] = (s.charAt(i) == '1') ? 1 : 0;
        }
        if (dim > s.length()) {
            for (int i = s.length(); i < dim; i++) {
                encoding[i] = 0;
            }
        }

        return encoding;
    }

    private static void printArray(int[] a) {
        for (int i = a.length-1; i >= 0; i--) {
            System.out.print(a[i]);
        }
        System.out.println("\n");
    }
}
