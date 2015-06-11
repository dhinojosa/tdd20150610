package com.xyzcorp;

import java.util.HashSet;
import java.util.Set;

public class NumberChain {
    private final int i;
    private Set<Integer> chainNumbers;

    public NumberChain(int i) {
        this.i = i;
        this.chainNumbers = new HashSet<Integer>();
    }

    public int length() {
        Integer result = null;
        Integer next = i;

        while ((!chainNumbers.contains(result))) {
            int desc = SortedInteger.sortDescending(next);
            int asc = SortedInteger.sortAscending(next);

            System.out.println(desc + "-" + asc);
            chainNumbers.add(result);
            result = SortedInteger.sortDescending(next) -
                     SortedInteger.sortAscending(next);
            System.out.println(result);
            next = result;
        }
        return chainNumbers.size();
    }
}
