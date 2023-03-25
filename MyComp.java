import java.util.Comparator;

import Libra.Assistant;

public class MyComp implements Comparator<Integer> {

    private sortEnum mode;
    private Assistant assistant;

    public MyComp(sortEnum mode) {
        this.mode = mode;
        this.assistant = new Assistant();
    }

    private int sumUp(int number){

        int sum = 0;
        int[] digits = this.assistant.splitToDigits(number);
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;

    }

    private int countDivisors(int number){
        int divisorsSum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) divisorsSum++; 
        }
        return divisorsSum;
    }


    @Override
    public int compare(Integer x, Integer y) {

        switch (mode) {
            case BY_VAL:
                return x - y;
            case BY_VAL_REV:
                return y - x; 
            case BY_SUM_OF_DIGS:
                return sumUp(x) - sumUp(y);
            case BY_NUM_OF_DIVS:
                return countDivisors(x) - countDivisors(y);
            //
            default: return 0;    
        }
    }

    
}

enum sortEnum {
    BY_VAL, 
    BY_VAL_REV,
    BY_NUM_OF_DIVS, 
    BY_SUM_OF_DIGS
}

