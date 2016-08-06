package org.klgraham.combinatorics;

import java.util.List;

/**
 * Created by klogram on 8/6/16.
 */
public abstract class Permutation<T extends Comparable<T>> {
    abstract List<T> next();
}
