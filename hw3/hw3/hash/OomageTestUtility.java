package hw3.hash;

import java.util.Iterator;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int[] bucketNumbers = new int[M];
        int bucketNumber;
        for (Oomage oomage : oomages) {
            bucketNumber = (oomage.hashCode() & 0x7FFFFFFF) % M;
            bucketNumbers[bucketNumber]++;
        }
        for (Oomage oomage : oomages) {
            bucketNumber = (oomage.hashCode() & 0x7FFFFFFF) % M;
            if (bucketNumbers[bucketNumber] < oomages.size() / 50 || bucketNumbers[bucketNumber] > oomages.size() / 2.5) {
                return false;
            }
        }

        return true;
    }
}
