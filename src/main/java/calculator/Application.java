package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public void putIntoArray(String number) {

        List<Character> numList = new ArrayList<>();

        for(char c : number.toCharArray()) {
            numList.add(c);
        }
    }
}
