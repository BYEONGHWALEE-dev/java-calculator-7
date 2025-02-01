package calculator;

public class NumPower {

    public int tenPower(int n){

        int result = 1;

        for(int i = 0; i < n; i++){

            result *= 10;
        }

        return result;
    }

    public int numPower(int num, int expo){

        int resultNum = num;

        for(int i = 0; i < expo; i++){

            resultNum *= num;
        }

        return resultNum;
    }
}
