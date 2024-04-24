package recursion;

public class Fibonacci {

    public int calculateFibonacci(int number) {
        if (number <= 0 ) {
            return 0;
        } else if(number == 1) {
            return 1;
        } else {
            return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
        }
    }

}
