package recursion;

public class Factorial {

    public long calculateFactorial(int number) {
        if (number <= 0) return 0;
        if (number > 1) {
            return number * calculateFactorial((number - 1));
        } else {
            return 1L;
        }
    }
}
