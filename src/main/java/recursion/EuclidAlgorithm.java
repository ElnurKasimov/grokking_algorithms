package recursion;

public class EuclidAlgorithm {
    public int findGreatestCommonDivisor(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (min <= 0) {
            return 0;
        } else if (max % min == 0) {
            return min;
        } else {
            int temp = min;
            min = max % min;
            max = temp;
            return findGreatestCommonDivisor(min, max);
        }
    }
}
