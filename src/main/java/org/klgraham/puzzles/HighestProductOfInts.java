package org.klgraham.puzzles;

/**
 * Given an array of integers, find the highestProduct you can get from three of the integers.
 The input a = [a_0, ..., a_{n-1}] will always have at least three integers.

 Can generate the n choose 3 combinations and compute the product of each one.

 Extend it to the highest product of four integers, then to k integers.
 */
public class HighestProductOfInts {
    /**
     * This is O(1) space and O(n) time
     */
    public static int findHighestProductOfThree(int[] a) {
        if (a.length < 3) {
            throw new IllegalArgumentException("The input array must have at least three elements.");
        }
        int n = a.length;

        int largest = Math.max(a[0], a[1]);
        int smallest = Math.min(a[0], a[1]);
        int largestPairProduct = a[0] * a[1];
        int smallestPairProduct = a[0] * a[1];
        int largestTripletProduct = a[0] * a[1] * a[2];

        for (int i = 2; i < n; i++) {
            int current = a[i];

            // unchanged, or product of current and (largest or smallest)PairProduct
            largestTripletProduct = Math.max(
                    Math.max(largestTripletProduct, current * largestPairProduct),
                    current * smallestPairProduct);

            largestPairProduct = Math.max(
                    Math.max(largestPairProduct, current * largest),
                    current * smallest);

            smallestPairProduct = Math.min(
                    Math.min(smallestPairProduct, current * largest),
                    current * smallest);

            largest = Math.max(largest, current);
            smallest = Math.min(smallest, current);
        }
        return largestTripletProduct;
    }

    public static int findHighestProductOfFour(int[] a) {
        if (a.length < 4) {
            throw new IllegalArgumentException("The input array must have at least three elements.");
        }
        int n = a.length;

        MinMax single = new MinMax();
        single.largest = Math.max(a[0], a[1]);
        single.smallest = Math.min(a[0], a[1]);

        MinMax pair = new MinMax();
        pair.largest = a[0] * a[1];
        pair.smallest = a[0] * a[1];

        MinMax triplet = new MinMax();
        triplet.largest = a[0] * a[1] * a[2];
        triplet.smallest = a[0] * a[1] * a[2];

        MinMax quartet = new MinMax();
        quartet.largest = a[0] * a[1] * a[2] * a[3];
        quartet.smallest = a[0] * a[1] * a[2] * a[3];

        for (int i = 2; i < n; i++) {
            int current = a[i];

            // unchanged, or product of current and (largest or smallest)PairProduct
            quartet.update(current * triplet.largest, current * triplet.smallest);
            triplet.update(current * pair.largest, current * pair.smallest);
            pair.update(current * single.largest, current * single.smallest);
            single.update(current);
        }
        return quartet.largest;
    }

    public static int findHighestProduct(int tupleSize, int[] a) {
        if (a.length < tupleSize) {
            throw new IllegalArgumentException(String.format("The input array must have at least %d elements.", tupleSize));
        }
        int n = a.length;

        // initialize
        MinMax[] statistics = new MinMax[tupleSize];
        statistics[0] = new MinMax();
        statistics[0].largest = Math.max(a[0], a[1]);
        statistics[0].smallest = Math.min(a[0], a[1]);
        statistics[1] = new MinMax();
        statistics[1].largest = a[0] * a[1];
        statistics[1].smallest = a[0] * a[1];

        int product = a[0] * a[1];
        for (int i = 2; i < tupleSize; i++) {
            product *= a[i];
            statistics[i] = new MinMax();
            statistics[i].largest = product;
            statistics[i].smallest = product;
        }

        for (int i = tupleSize - 2; i < n; i++) {
            int current = a[i];

            for (int j = tupleSize - 1; j > 0; j--) {
                statistics[j].update(current * statistics[j-1].largest, current * statistics[j-1].smallest);
            }
            statistics[0].update(current);
        }
        return statistics[tupleSize-1].largest;
    }

    public static int highestProductOf3(int[] arrayOfInts) {
        if (arrayOfInts.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // We're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
        int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

        // except this one--we pre-populate it for the first /3/ items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

        // walk through items, starting at index 2
        for (int i = 2; i < arrayOfInts.length; i++) {
            int current = arrayOfInts[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }

    public static void main(String[] args) {
        System.out.println(findHighestProductOfThree(new int[]{ -10, 10, 4, -34, 6}));
        System.out.println(findHighestProduct(3, new int[]{ -10, 10, 4, -34, 6}));
        System.out.println(findHighestProductOfThree(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(findHighestProduct(3, new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(findHighestProductOfFour(new int[]{ -10, 10, 4, -34, 6, 5, -35}));
        System.out.println(findHighestProduct(4, new int[]{ -10, 10, 4, -34, 6, 5, -35}));
        System.out.println(findHighestProduct(5, new int[]{ -10, 10, 4, -34, 6, 5, -35}));
        System.out.println(findHighestProduct(5, new int[]{ -35, -34, -10, 10, 4, 6, 5}));
        System.out.println(highestProductOf3(new int[]{-10, -10, 1, 3, 2}));
        System.out.println(highestProductOf3(new int[]{-10, -10, 2, 3}));
    }

    static class MinMax {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        public void update(int a) {
            largest = Math.max(largest, a);
            smallest = Math.min(smallest, a);
        }

        public void update(int a, int b) {
            largest = Math.max(Math.max(largest, a), b);
            smallest = Math.min(Math.min(smallest, a), b);
        }
    }
}
