package org.klgraham.puzzles;

import java.util.Arrays;
import java.util.Comparator;

/**
 * *** Interview Cake Problem 2
 You have a list of integers, and for each index you want to find the
 product of every integer except the integer at that index.

 Write a function get_products_of_all_ints_except_at_index() that takes
 a list of integers and returns a list of the products.

 https://www.interviewcake.com/question/python/product-of-other-numbers

 Do not use division
 Want the product of numbers before the specified index and the product
 of the numbers after the specified index

 * @author Kenneth Graham
 */
public class ProductOfAllOtherInts {
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] a) {
        int n = a.length;

        int[] products = new int[n];
        int productSoFar = 1;

        // fwd pass
        for (int i = 0; i < n; i++) {
            products[i] = productSoFar;
            productSoFar *= a[i];
        }

        // backward pass
        productSoFar = 1;
        for (int i = n-1; i >= 0; i--) {
            products[i] *= productSoFar;
            productSoFar *= a[i];
        }

        return products;
    }

    public static void main(String[] args) {
        getProductsOfAllIntsExceptAtIndex(new int[]{1,2,6,5,9});
    }
}
