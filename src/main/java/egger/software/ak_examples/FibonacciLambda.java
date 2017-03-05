package egger.software.ak_examples;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;

class FibonacciLambda {

    static LongUnaryOperator operator;

    public static void main(String[] args) {

        // The problem is that we can not use the function declared inside the definition.
        // Self reference is not allowed.

        BiFunction<BiFunction, Long, Long> fibonacciStep = (f, n) -> n == 0 || n == 1 ?
                1 : (long) f.apply(f, n - 1) + (long) f.apply(f, n - 2);

        Function<Long, Long> fibonacci = n -> fibonacciStep.apply(fibonacciStep, n);

        System.out.println(fibonacci.apply(0l));
        System.out.println(fibonacci.apply(1l));
        System.out.println(fibonacci.apply(2l));
        System.out.println(fibonacci.apply(3l));
        System.out.println(fibonacci.apply(4l));
        System.out.println(fibonacci.apply(5l));
        System.out.println(fibonacci.apply(6l));
        System.out.println(fibonacci.apply(22l));

        // fib is not final !
        // LongUnaryOperator fib = null;
        // fib = n ->  n == 0 || n == 1 ?
        //        1 : fib.applyAsLong(n-1) + fib.applyAsLong(n - 2);


        operator = n ->  n == 0 || n == 1 ?
                1 : operator.applyAsLong(n - 1) + operator.applyAsLong(n - 2);

        System.out.println(operator.applyAsLong(0l));
        System.out.println(operator.applyAsLong(1l));
        System.out.println(operator.applyAsLong(2l));
        System.out.println(operator.applyAsLong(3l));
        System.out.println(operator.applyAsLong(4l));
        System.out.println(operator.applyAsLong(5l));
        System.out.println(operator.applyAsLong(6l));
        System.out.println(operator.applyAsLong(22l));
    }

}
