
import java.util.function.Function;

public class HappyNumberClass {
    public static void main(String[] args) {
        int n = 23;
        if (isHappynumberMethod(n))
            System.out.println(n +
                    " is a Happy number");
        else
            System.out.println(n +
                    " is not a Happy number");
    }
    static Function<Integer, Integer> sumOfSquaresOfDigitsFunction = number ->
    {
        Integer sum = 0;
        while (number != 0) {
            Integer remainNumber = number % 10;
            sum = remainNumber * remainNumber + sum;
            number /= 10;
        }
        return sum;
    };
    // return type true if sum is leading in 1 else false
    public static boolean isHappynumberMethod(int n) {
        int firstSum, secondNumber;
        //  initialize slow and fast by n
        firstSum = secondNumber = n;
        do {
            firstSum = sumOfSquaresOfDigitsFunction.apply(firstSum);
            secondNumber = sumOfSquaresOfDigitsFunction
                    .apply(sumOfSquaresOfDigitsFunction.apply(secondNumber));
        }
        while (firstSum != secondNumber);
        //  if both number meet at 1,
        // then return true
        return (secondNumber == 1);
    }
}

