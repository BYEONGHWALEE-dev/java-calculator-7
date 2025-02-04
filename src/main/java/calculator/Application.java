package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculFunc calculFunc = new CalculFunc();
        List<Integer> finalList = new ArrayList<>();
        int resultNum = 0;
        //구분자 지정
        List<Character> sepList = new ArrayList<>();
        sepList.add(',');
        sepList.add(':');

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        List<Character> tempList = new ArrayList<>();
        putIntoArray(input, tempList);


        // 구분자 지정인지 아닌지 검증
        // 구분자 지정 아닐 때
        if (!calculFunc.validateList(tempList)) {

            finalList = calculFunc.extractNumber(tempList, sepList);
            resultNum = calculFunc.addAllNum(finalList);

            System.out.println("결과 : " + resultNum);
        }
        // 구분자 지정일 때
        else {

            //구분지 지정 리스트 초기화 후 다시 삽입
             sepList.clear();
             char sep = calculFunc.pullSeperator(tempList);
             sepList.add(sep);

            finalList = calculFunc.extractNumber(tempList, sepList);
            resultNum = calculFunc.addAllNum(finalList);

            System.out.println("결과 : " + resultNum);

        }




    }

    public static void putIntoArray(String number, List<Character> numList) {

        for (char c : number.toCharArray()) {
            numList.add(c);
        }
    }

}
